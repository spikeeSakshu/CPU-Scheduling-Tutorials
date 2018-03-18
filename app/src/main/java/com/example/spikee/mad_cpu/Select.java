package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        TextView tx_fcfs=findViewById(R.id.title_fcfs);
        TextView tx_basics=findViewById(R.id.title_basics);
        TextView tx_sjf=findViewById(R.id.title_sjf);
        TextView tx_priority=findViewById(R.id.title_priority);
        TextView tx_rr=findViewById(R.id.title_rr);


        basics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,Intro.class);
                startActivity(in);
            }
        });
        tx_basics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,Intro.class);
                startActivity(in);
            }
        });

        tx_fcfs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,fcfs.class);
                startActivity(in);
            }
        });
        fcfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,fcfs.class);
                startActivity(in);
            }
        });

        tx_sjf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,sjf.class);
                startActivity(in);
            }
        });
        sjf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,sjf.class);
                startActivity(in);
            }
        });

        tx_priority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,priority.class);
                startActivity(in);
            }
        });
        priority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,priority.class);
                startActivity(in);
            }
        });

        tx_rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,rr.class);
                startActivity(in);
            }
        });
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Select.this,rr.class);
                startActivity(in);
            }
        });




    }
}
