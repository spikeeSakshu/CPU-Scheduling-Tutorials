package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fcfs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcfs);
     Button ex=findViewById(R.id.ex_fcfs);
     ex.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent in=new Intent(fcfs.this,fcfs_ex.class);
             startActivity(in);
         }
     });


    }
}
