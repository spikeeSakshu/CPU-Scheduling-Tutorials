package com.example.spikee.mad_cpu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        String  stringset1,stringset2,stringset3,functionname,stringset4,stringset5,stringset6;

        ArrayList<Integer> tasklist;
        ArrayList<Integer> priority_list;
        ArrayList<Integer> brust_time_list;
        ArrayList<Integer>waiting_time_list;
        ArrayList<Integer>turn_around_list;
        float average_waiting_time;



        int total_task = getIntent().getIntExtra("Total task",0);
        priority_list = getIntent().getIntegerArrayListExtra("Priority value");
        tasklist = getIntent().getIntegerArrayListExtra("Task number");
        brust_time_list = getIntent().getIntegerArrayListExtra("Brust time");
        waiting_time_list= getIntent().getIntegerArrayListExtra("Waiting time");
        turn_around_list=getIntent().getIntegerArrayListExtra("turn around time");
        average_waiting_time=getIntent().getFloatExtra("average waiting time", 0);
        functionname=getIntent().getStringExtra("Function name");

        TextView function=(TextView)findViewById(R.id.Functionname);
        function.setText(functionname);

        TextView average_waitingtime_textview=(TextView)findViewById(R.id.average_waiting_time);
        String s = String.format("%.2f", average_waiting_time);
        String average="Average Waiting Time="+ s;
        average_waitingtime_textview.setText(average);

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.text_container);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        for (int i = 0; i < total_task; i++) {
            //Creating a textbox
            TextView Textview1 = new TextView(this);//new object of textbox is created
            Textview1.setLayoutParams(params1);
            linearLayout1.addView(Textview1);//textbox is created
            stringset1 = "Task Number: " + Integer.toString(tasklist.get(i));
            Textview1.setText(stringset1);//Setting unique names to easch tasks
            Textview1.setTextSize(26);

            //Creating a textbox
            TextView Textview4 = new TextView(this);//new object of textbox is created
            Textview4.setLayoutParams(params1);
            linearLayout1.addView(Textview4);//textbox is created
            stringset4 = "Task Name: T" + Integer.toString(tasklist.get(i));
            Textview4.setText(stringset4);//Setting unique names to easch tasks
            Textview4.setTextSize(26);

            //Creating a textbox
            TextView Textview2 = new TextView(this);//new object of textbox is created
            Textview2.setLayoutParams(params1);
            linearLayout1.addView(Textview2);//textbox is created
            stringset2 = "Priority Value: " + Integer.toString(priority_list.get(i));
            Textview2.setText(stringset2);//Setting unique names to easch tasks
            Textview2.setTextSize(26);

            //Creating a textbox
            TextView Textview3 = new TextView(this);//new object of textbox is created
            Textview3.setLayoutParams(params1);
            linearLayout1.addView(Textview3);//textbox is created
            stringset3 = "Burst Time: " + Integer.toString(brust_time_list.get(i));
            Textview3.setText(stringset3);//Setting unique names to easch tasks
            Textview3.setTextSize(26);

            //Creating a textbox
            TextView Textview5 = new TextView(this);//new object of textbox is created
            Textview5.setLayoutParams(params1);
            linearLayout1.addView(Textview5);//textbox is created
            stringset5 = "Waiting Time: " + Integer.toString(waiting_time_list.get(i));
            Textview5.setText(stringset5);//Setting unique names to easch tasks
            Textview5.setTextSize(26);

            //Creating a textbox
            TextView Textview6 = new TextView(this);//new object of textbox is created
            Textview6.setLayoutParams(params1);
            linearLayout1.addView(Textview6);//textbox is created
            stringset6 = "Turn Around Time: " + Integer.toString(turn_around_list.get(i));
            Textview6.setText(stringset6);//Setting unique names to easch tasks
            Textview6.setTextSize(26);

            View v = new View(this);
            v.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 5));
            v.setBackgroundColor(Color.parseColor("#B3B3B3"));

            linearLayout1.addView(v);

        }
    }
}
