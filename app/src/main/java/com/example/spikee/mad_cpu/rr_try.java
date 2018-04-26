package com.example.spikee.mad_cpu;


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class rr_try extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjf_pre_try);
        count=1;
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



    public void p4(View view) {
        if(count==1) {
            findViewById(R.id.Gant_SJF_pre_1).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p1(View view) {
        if(count==2) {
            findViewById(R.id.Gant_SJF_pre_2).setVisibility(View.VISIBLE);
            count++;
        }
        else if(count==6) {
            findViewById(R.id.Gant_SJF_pre_6).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p5(View view) {
        if(count==3) {
            findViewById(R.id.Gant_SJF_pre_3).setVisibility(View.VISIBLE);
            count++;
        }
        else if(count==5) {
            findViewById(R.id.Gant_SJF_pre_5).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p2(View view) {
        if(count==4) {
            findViewById(R.id.Gant_SJF_pre_4).setVisibility(View.VISIBLE);
            count++;
        }
        else {
            Toast.makeText(this,"Wrong selection",Toast.LENGTH_SHORT).show();
        }
    }

    public void p3(View view) {
        if(count==7) {
            findViewById(R.id.Gant_SJF_pre_7).setVisibility(View.VISIBLE);
            count++;
            findViewById(R.id.SJF_pre_button).setVisibility(View.VISIBLE);
            findViewById(R.id.SJF_pre_table).setVisibility(View.VISIBLE);
            findViewById(R.id.SJF_pre_text).setVisibility(View.VISIBLE);
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
        idct.add((EditText) findViewById(R.id.SJF_pre_p1_ct));
        idct.add((EditText) findViewById(R.id.SJF_pre_p2_ct));
        idct.add((EditText) findViewById(R.id.SJF_pre_p3_ct));
        idct.add((EditText) findViewById(R.id.SJF_pre_p4_ct));
        idct.add((EditText) findViewById(R.id.SJF_pre_p5_ct));
        idwt.add((EditText) findViewById(R.id.SJF_pre_p1_wt));
        idwt.add((EditText) findViewById(R.id.SJF_pre_p2_wt));
        idwt.add((EditText) findViewById(R.id.SJF_pre_p3_wt));
        idwt.add((EditText) findViewById(R.id.SJF_pre_p4_wt));
        idwt.add((EditText) findViewById(R.id.SJF_pre_p5_wt));
        String arrct[] ={"5","10","16","1","18"};
        String arrwt[] ={"0","3","7","0","12"};
        int i;
        for(i=0;i<5;i++) {
            if(idct.get(i).getText().toString().compareTo(arrct[i])!=0) {
                Toast.makeText(this,"Wrong Input for P"+(i+1)+" \n Please try again",Toast.LENGTH_SHORT).show();
                break;
            }
            if(idwt.get(i).getText().toString().compareTo(arrwt[i])!=0) {
                Toast.makeText(this,"Wrong Input for P"+(i+1)+"\n Please try again",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if(i==5) {
            fin();
        }
    }

}
