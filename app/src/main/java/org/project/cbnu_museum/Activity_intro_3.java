package org.project.cbnu_museum;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_intro_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("조직 및 업무");
    }
}