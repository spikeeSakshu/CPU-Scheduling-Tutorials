package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fcfs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcfs);

        Button pree=findViewById(R.id.pree);
        Button non_pree=findViewById(R.id.non_pree);

        pree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(fcfs.this,fcfs_pree.class);
                startActivity(in);
            }
        });
        non_pree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(fcfs.this,fcfs_non_pree.class);
                startActivity(in);
            }
        });


    }
}
