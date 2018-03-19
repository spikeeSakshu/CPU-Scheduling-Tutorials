package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Spikee on 19-03-2018.
 */

public class singup_tab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.signup_tab,container,false);
       Button b=v.findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Select.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
