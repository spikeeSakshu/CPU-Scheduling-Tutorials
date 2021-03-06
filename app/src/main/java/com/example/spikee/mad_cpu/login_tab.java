package com.example.spikee.mad_cpu;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Spikee on 19-03-2018.
 */

public class login_tab extends Fragment implements View.OnClickListener {

    private Button login;
    private TextInputEditText email;
    private TextInputEditText password;
    private TextView tv1;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_tab, container, false);

        email=v.findViewById(R.id.email);
        password=v.findViewById(R.id.password);
        login = v.findViewById(R.id.lo);
        tv1 = v.findViewById(R.id.forgotw);
        progressDialog=new ProgressDialog(getActivity());
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null)
        {
            Intent in=new Intent(getActivity(),Switch.class);
            startActivity(in);
        }


        login.setOnClickListener(this);
        tv1.setOnClickListener(this);

        return v;
    }
    private void  userLogin()
    {
        String em=email.getText().toString().trim();
        String pass=password.getText().toString().trim();

        if(TextUtils.isEmpty(em))
        {
            //email is empty
            Toast.makeText(getActivity(),"Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            //password is empty
            Toast.makeText(getActivity(),"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("LoginIn User....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(em,pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful())
                {
                 startActivity(new Intent(getActivity(),Switch.class));
                }
                else
                {
                    Toast.makeText(getActivity(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        if(view==login)
        {
            userLogin();
        }
        if(view==tv1)
        {
            AlertDialog.Builder mbuilder = new AlertDialog.Builder(getActivity());
            View mview = getLayoutInflater().inflate(R.layout.forgot, null);
            final TextInputLayout textInputLayout = mview.findViewById(R.id.text_input);
            final TextInputEditText et = (TextInputEditText) mview.findViewById(R.id.et);
            final TextView tv = mview.findViewById(R.id.tv);
            final Button send = (Button) mview.findViewById(R.id.send);
            ImageButton ib = (ImageButton) mview.findViewById(R.id.ib);
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!et.getText().toString().isEmpty()) {
                        Toast.makeText(getActivity(), "Email Sent", Toast.LENGTH_SHORT).show();
                        tv.setText("Reset email sent");
                        textInputLayout.setVisibility(View.GONE);
                        send.setVisibility(View.GONE);

                    } else {
                        Toast.makeText(getActivity(), "Please enter a valid Email Address", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            mbuilder.setView(mview);
            final AlertDialog dialog = mbuilder.create();
            dialog.show();
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();

                }
            });
        }

    }
}

