package com.example.spikee.mad_cpu;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Spikee on 19-03-2018.
 */

public class login_tab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_tab, container, false);


        Button lo = v.findViewById(R.id.lo);
        TextView tv1 = v.findViewById(R.id.forgotw);
        lo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Select.class);
                View m = getLayoutInflater().inflate(R.layout.forgot, null);
                startActivity(intent);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
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
        });

        return v;
    }
}

