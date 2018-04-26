package com.example.spikee.mad_cpu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class calc extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int task_no=1,prority_value,brust_time, number_of_field = 0;//for number of tasks and number of respective values

    int  i = 0,j=0;//for sorting
    int temp_brust,temp_priority,temp_task;//for swapping during sording

    TextView text_view;
    String  bruststring,prioritystring;

    // Create a linkedlist
    ArrayList<Integer> tasklist = new ArrayList<Integer>();
    ArrayList<Integer> priority_list = new ArrayList<Integer>();
    ArrayList<Integer> brust_time_list = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.out, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_fcfs) {
            Intent in=new Intent(this,Fcfs.class);
            startActivity(in);
            finish();

        } else if (id == R.id.nav_sjf) {
            Intent in=new Intent(this,Sjf.class);
            startActivity(in);
            finish();

        } else if (id == R.id.nav_priority) {
            Intent in=new Intent(this,Priority.class);
            startActivity(in);
            finish();

        } else if (id == R.id.nav_rr) {
            Intent in=new Intent(this,Rr.class);
            startActivity(in);
            finish();

        } else if (id == R.id.nav_signout) {
//            Intent in=new Intent(this,.class);
//            startActivity(in);
//            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public int ADD(View view) {

        EditText priority_editbox=(EditText)findViewById(R.id.priority_editbox);
        prioritystring=priority_editbox.getText().toString();
        if(prioritystring == null || prioritystring.trim().equals("")){//check if user has input something or not
            Toast.makeText(calc.this, "No Priority Value", Toast.LENGTH_SHORT).show();
            return 1;//control out of function
        }
        else {
            prority_value = Integer.parseInt(prioritystring);// VALUE OF PRIORITY is taken fron editbox

        }


        EditText brust_time_editbox=(EditText)findViewById(R.id.brust_time_editbox);
        bruststring=brust_time_editbox.getText().toString();
        if(bruststring== null || bruststring.trim().equals("")){//check if user has input something or not
            Toast.makeText(calc.this, "No Burst Time Value", Toast.LENGTH_SHORT).show();
            return 1;//control out of function
        }
        else {
            brust_time = Integer.parseInt(bruststring);// VALUE OF brust time is taken fron editbox
        }

        task_no++;//task_no value increased for next click
        text_view=(TextView)findViewById(R.id.textbox_number);
        text_view.setText(Integer.toString(task_no));

        //for task name
        text_view=(TextView)findViewById(R.id.textbox_name);
        String task_name="T"+Integer.toString(task_no);
        text_view.setText(task_name);


        //new node is created using task number, priority value, brust time
        tasklist.add(new Integer(number_of_field+1));
        priority_list.add(new Integer(prority_value));
        brust_time_list.add(new Integer(brust_time));
        number_of_field++;


//For showing the Arraylist in main screen
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.text_container);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        //Creating a textbox for task
        TextView Textview1 = new TextView(this);//new object of textbox is created
        Textview1.setLayoutParams(params1);
        linearLayout1.addView(Textview1);//textbox is created
        Textview1.setText("Task Number: "+ Integer.toString(number_of_field));//Setting unique number to easch tasks
        Textview1.setTextSize(26);


        //Creating a textbox for taskname
        TextView Textview4 = new TextView(this);//new object of textbox is created
        Textview4.setLayoutParams(params1);
        linearLayout1.addView(Textview4);//textbox is created
        Textview4.setText("Task Name: T" + Integer.toString(number_of_field));//Setting unique names to easch tasks
        Textview4.setTextSize(26);

        //Creating a textbox for priority
        TextView Textview2 = new TextView(this);//new object of textbox is created
        Textview2.setLayoutParams(params1);
        linearLayout1.addView(Textview2);//textbox is created
        Textview2.setText("Priority Value: "+prioritystring);//Setting unique names to easch tasks
        Textview2.setTextSize(26);

        //Creating a textbox for brust time
        TextView Textview3 = new TextView(this);//new object of textbox is created
        Textview3.setLayoutParams(params1);
        linearLayout1.addView(Textview3);//textbox is created
        Textview3.setText("Burst Time: "+bruststring);//Setting unique names to easch tasks
        Textview3.setTextSize(26);

        View v = new View(this);//for creating a line
        v.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 5));
        v.setBackgroundColor(Color.parseColor("#B3B3B3"));
        linearLayout1.addView(v);

        priority_editbox.getText().clear();//clearing editboxes
        brust_time_editbox.getText().clear();//clearing editboxes

        //hiding keyboard to get full view
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        return 1;//returning control
    }



    public void FCFS(View view) {
        ArrayList<Integer> waiting_time = new ArrayList<Integer>();
        ArrayList<Integer> turn_around_time = new ArrayList<Integer>();
        float average_waiting_time;
        float total_waiting_time=0,total_turnaround_time=0;
        int wait_time=0;

        for(i=0;i<number_of_field;i++)              // calculating total waiting time and filling arraylist
        {
            for(j=0;j<i;j++)
            {
                wait_time=wait_time+brust_time_list.get(j);

            }

            waiting_time.add(new Integer(wait_time));
            total_waiting_time+=waiting_time.get(i);
            wait_time=0;
        }

        average_waiting_time=total_waiting_time/number_of_field;//calculating average waiting list

        for(i=0;i<number_of_field;i++)                 //  calculating total turn around time and filling arraylist
        {
            int turn_around = brust_time_list.get(i) + waiting_time.get(i);
            turn_around_time.add(new Integer(turn_around));
            total_turnaround_time+=turn_around_time.get(i);
        }


        // Create a new intent to open the {@link ShowActivity}
        Intent showIntent = new Intent(calc.this, show.class);
        showIntent.putExtra("Total task", number_of_field);
        showIntent.putIntegerArrayListExtra("Task number",tasklist);
        showIntent.putIntegerArrayListExtra("Priority value",priority_list);
        showIntent.putIntegerArrayListExtra("Brust time",brust_time_list);
        showIntent.putIntegerArrayListExtra("Waiting time",waiting_time);
        showIntent.putIntegerArrayListExtra("turn around time",turn_around_time);
        showIntent.putExtra("average waiting time", average_waiting_time);
        showIntent.putExtra("Function name","First Come First Serve");


        // Start the new activity
        startActivity(showIntent);
    }

    public void SJF(View view) {

        // Create a local Arraylist to sort without effecting the actual Arraylist
        ArrayList<Integer> tasklist = new ArrayList<Integer>();
        ArrayList<Integer> priority_list = new ArrayList<Integer>();
        ArrayList<Integer> brust_time_list = new ArrayList<Integer>();

        //assigning local arraylist = global arraylist using addAll function
        //creating a copy of arraylist
        tasklist.addAll(this.tasklist);
        priority_list.addAll(this.priority_list);
        brust_time_list.addAll(this.brust_time_list);


        //assending order sorting according to brust time
        for(i=0;i<number_of_field;i++)
        {
            for (j = i+1; j < number_of_field; j++)
            {

                if (brust_time_list.get(j) < brust_time_list.get(i))
                {
                    temp_brust=brust_time_list.get(i);
                    brust_time_list.set(i, brust_time_list.get(j));
                    brust_time_list.set(j, temp_brust);

                    temp_task=tasklist.get(i);
                    tasklist.set(i, tasklist.get(j));
                    tasklist.set(j, temp_task);

                    temp_priority=priority_list.get(i);
                    priority_list.set(i, priority_list.get(j));
                    priority_list.set(j, temp_priority);

                }

            }
        }

        ArrayList<Integer> waiting_time = new ArrayList<Integer>();
        ArrayList<Integer> turn_around_time = new ArrayList<Integer>();
        float average_waiting_time;
        float total_waiting_time=0,total_turnaround_time=0;
        int wait_time=0;

        for(i=0;i<number_of_field;i++)              // calculating total waiting time and filling arraylist
        {
            for(j=0;j<i;j++)
            {
                wait_time=wait_time+brust_time_list.get(j);

            }

            waiting_time.add(new Integer(wait_time));
            total_waiting_time+=waiting_time.get(i);
            wait_time=0;
        }

        average_waiting_time=total_waiting_time/number_of_field;//calculating average waiting list

        for(i=0;i<number_of_field;i++)                 //  calculating total turn around time and filling arraylist
        {
            int turn_around = brust_time_list.get(i) + waiting_time.get(i);
            turn_around_time.add(new Integer(turn_around));
            total_turnaround_time+=turn_around_time.get(i);
        }


        // Create a new intent to open the {@link ShowActivity}
        Intent showIntent = new Intent(calc.this, show.class);
        showIntent.putExtra("Total task", number_of_field);
        showIntent.putIntegerArrayListExtra("Task number",tasklist);
        showIntent.putIntegerArrayListExtra("Priority value",priority_list);
        showIntent.putIntegerArrayListExtra("Brust time",brust_time_list);
        showIntent.putIntegerArrayListExtra("Waiting time",waiting_time);
        showIntent.putIntegerArrayListExtra("turn around time",turn_around_time);
        showIntent.putExtra("average waiting time", average_waiting_time);
        showIntent.putExtra("Function name","Shortest Job First");


        // Start the new activity
        startActivity(showIntent);
    }

    public void PRIORITY(View view) {

        // Create a local Arraylist to sort without effecting the actual Arraylist
        ArrayList<Integer> tasklist = new ArrayList<Integer>();
        ArrayList<Integer> priority_list = new ArrayList<Integer>();
        ArrayList<Integer> brust_time_list = new ArrayList<Integer>();

        //assigning local arraylist = global arraylist using addAll function
        //creating a copy of arraylist
        tasklist.addAll(this.tasklist);
        priority_list.addAll(this.priority_list);
        brust_time_list.addAll(this.brust_time_list);


        //dessending order sorting according to priority
        for(i=0;i<number_of_field;i++)
        {
            for (j = i+1; j < number_of_field; j++)
            {

                if (priority_list.get(j) > priority_list.get(i))
                {
                    temp_brust=brust_time_list.get(i);
                    brust_time_list.set(i, brust_time_list.get(j));
                    brust_time_list.set(j, temp_brust);

                    temp_task=tasklist.get(i);
                    tasklist.set(i, tasklist.get(j));
                    tasklist.set(j, temp_task);

                    temp_priority=priority_list.get(i);
                    priority_list.set(i, priority_list.get(j));
                    priority_list.set(j, temp_priority);

                }

            }
        }
        ArrayList<Integer> waiting_time = new ArrayList<Integer>();
        ArrayList<Integer> turn_around_time = new ArrayList<Integer>();
        float average_waiting_time;
        float total_waiting_time=0,total_turnaround_time=0;
        int wait_time=0;

        for(i=0;i<number_of_field;i++)              // calculating total waiting time and filling arraylist
        {
            for(j=0;j<i;j++)
            {
                wait_time=wait_time+brust_time_list.get(j);

            }

            waiting_time.add(new Integer(wait_time));
            total_waiting_time+=waiting_time.get(i);
            wait_time=0;
        }

        average_waiting_time=total_waiting_time/number_of_field;//calculating average waiting list

        for(i=0;i<number_of_field;i++)                 //  calculating total turn around time and filling arraylist
        {
            int turn_around = brust_time_list.get(i) + waiting_time.get(i);
            turn_around_time.add(new Integer(turn_around));
            total_turnaround_time+=turn_around_time.get(i);
        }


        // Create a new intent to open the {@link ShowActivity}
        Intent showIntent = new Intent(calc.this, show.class);
        showIntent.putExtra("Total task", number_of_field);
        showIntent.putIntegerArrayListExtra("Task number",tasklist);
        showIntent.putIntegerArrayListExtra("Priority value",priority_list);
        showIntent.putIntegerArrayListExtra("Brust time",brust_time_list);
        showIntent.putIntegerArrayListExtra("Waiting time",waiting_time);
        showIntent.putIntegerArrayListExtra("turn around time",turn_around_time);
        showIntent.putExtra("average waiting time", average_waiting_time);
        showIntent.putExtra("Function name","Priority Queue");


        // Start the new activity
        startActivity(showIntent);
    }


    public void reset(View view) {

        //restarting the app
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }
}
