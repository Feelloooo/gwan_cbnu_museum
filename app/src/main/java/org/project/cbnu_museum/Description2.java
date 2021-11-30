package org.project.cbnu_museum;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.examples.classification.tflite.Classifier;

public class Description2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("쌍코뿔이");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        setResult(RESULT_OK, new Intent(this, Classifier.class));
    }
}