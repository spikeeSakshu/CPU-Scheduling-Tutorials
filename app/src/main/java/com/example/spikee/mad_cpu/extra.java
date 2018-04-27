package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;

public class extra extends AppCompatActivity
         {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);


    }

    public void back(View view) {
        startActivity(new Intent(this,Select.class));
    }

    public void refer(View view) {
        String link = "https://www.studytonight.com/operating-system/cpu-scheduling";
        Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
}
