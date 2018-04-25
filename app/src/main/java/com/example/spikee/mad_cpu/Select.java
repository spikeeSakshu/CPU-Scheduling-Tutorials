package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ImageView basics=findViewById(R.id.basics);
        ImageView fcfs=findViewById(R.id.fcfs);
        ImageView sjf=findViewById(R.id.sjf);
        ImageView priority=findViewById(R.id.priority);
        ImageView rr=findViewById(R.id.rr);


        basics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,Intro.class);
                startActivity(in);
            }
        });

        fcfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,Fcfs.class);
                startActivity(in);
            }
        });
        sjf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,Sjf.class);
                startActivity(in);
            }
        });
        priority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,Priority.class);
                startActivity(in);
            }
        });
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,Rr.class);
                startActivity(in);
            }
        });




    }
}
