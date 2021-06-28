package org.project.cbnu_museum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_floor_info extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("층별 안내");

        Button button1 = findViewById(R.id.first_floor);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_floor_1.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.second_floor);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_floor_2.class);
                startActivity(intent);

            }
        });

    }

}