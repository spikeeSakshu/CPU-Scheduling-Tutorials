package com.example.spikee.mad_cpu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class extra extends AppCompatActivity {

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
