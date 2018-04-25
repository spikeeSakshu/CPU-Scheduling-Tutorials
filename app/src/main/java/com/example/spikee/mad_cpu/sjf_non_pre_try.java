package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class sjf_non_pre_try extends AppCompatActivity {
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjf_non_pre_try);
        count=1;
    }

    public void p4(View view) {
        if(count==1) {
            findViewById(R.id.Gant_SJF_non_pre_1).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p1(View view) {
        if(count==2) {
            findViewById(R.id.Gant_SJF_non_pre_2).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p2(View view) {
        if(count==3) {
            findViewById(R.id.Gant_SJF_non_pre_3).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p3(View view) {
        if(count==4) {
            findViewById(R.id.Gant_SJF_non_pre_4).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p5(View view) {
        if(count==5) {
            findViewById(R.id.Gant_SJF_non_pre_5).setVisibility(View.VISIBLE);
            count++;
            findViewById(R.id.SJF_non_pre_button).setVisibility(View.VISIBLE);
            findViewById(R.id.SJF_non_pre_table).setVisibility(View.VISIBLE);
            findViewById(R.id.SJF_non_pre_text).setVisibility(View.VISIBLE);

        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void fin() {
        Intent intent =new Intent(this, extra.class);
        startActivity(intent);
    }

    public void submit(View view) {
        ArrayList<EditText> idct =new ArrayList<>();
        ArrayList<EditText> idwt =new ArrayList<>();
        idct.add((EditText) findViewById(R.id.SJF_non_pre_p1_ct));
        idct.add((EditText) findViewById(R.id.SJF_non_pre_p2_ct));
        idct.add((EditText) findViewById(R.id.SJF_non_pre_p3_ct));
        idct.add((EditText) findViewById(R.id.SJF_non_pre_p4_ct));
        idct.add((EditText) findViewById(R.id.SJF_non_pre_p5_ct));
        idwt.add((EditText) findViewById(R.id.SJF_non_pre_p1_wt));
        idwt.add((EditText) findViewById(R.id.SJF_non_pre_p2_wt));
        idwt.add((EditText) findViewById(R.id.SJF_non_pre_p3_wt));
        idwt.add((EditText) findViewById(R.id.SJF_non_pre_p4_wt));
        idwt.add((EditText) findViewById(R.id.SJF_non_pre_p5_wt));
        String arrct[] ={"5","10","16","1","18"};
        String arrwt[] ={"0","3","7","0","12"};
        int i;
        for(i=0;i<5;i++) {
            if(idct.get(i).getText().toString().compareTo(arrct[i])!=0) {
                Toast.makeText(this,"Wrong Input for P"+(i+1)+" \n Please try again",Toast.LENGTH_SHORT).show();
                break;
            }
            if(idwt.get(i).getText().toString().compareTo(arrwt[i])!=0) {
                Toast.makeText(this,"Wrong Input for p"+(i+1)+"\n Please try again",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if(i==5) {
            fin();
        }
    }

}
