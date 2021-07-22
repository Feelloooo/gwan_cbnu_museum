package org.project.cbnu_museum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Activity_loading extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ImageView imageview = findViewById(R.id.imageview);
        Glide.with(this).load(R.raw.unnamed).into(imageview);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 1500);

    }

    private class splashhandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class));
            Activity_loading.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        //
        //
    }
}
