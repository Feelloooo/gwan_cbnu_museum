package org.project.cbnu_museum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.examples.classification.tflite.Classifier;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_fllipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //actionbar에 로고
        getSupportActionBar().setIcon(R.drawable.actionbar_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //hashkey발급
        //getHashKey();

        //메인화면 이미지
        int images[] = {
                R.drawable.main_img1,
                R.drawable.main_img2,
                R.drawable.main_img3,
                R.drawable.main_img4
        };
        v_fllipper = findViewById(R.id.image_slide);
        for(int image : images) {
            fllipperImages(image);
        }

        Button button1 = findViewById(R.id.menu1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_heritage.class);
                startActivity(intent);
            }
        });

        //층별안내
        Button button2 = findViewById(R.id.menu2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_floor_info.class);
                startActivity(intent);
            }
        });
        Button button3 = findViewById(R.id.menu3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_intro.class);
                startActivity(intent);
            }
        });
        Button button4 = findViewById(R.id.menu4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassifierActivity.class);
                startActivity(intent);
            }
        });

        //오시는길
        Button button5 = findViewById(R.id.menu5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_route.class);
                startActivity(intent);
            }
        });

    }
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(2000);   // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);      // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(this,R.anim.slide_in_right);
        v_fllipper.setOutAnimation(this,R.anim.slide_out_left);
    }

//    hashkey발급
//        private void getHashKey(){
//            PackageInfo packageInfo = null;
//            try {
//                packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//            if (packageInfo == null)
//                Log.e("KeyHash", "KeyHash:null");
//
//            for (Signature signature : packageInfo.signatures) {
//                try {
//                    MessageDigest md = MessageDigest.getInstance("SHA");
//                    md.update(signature.toByteArray());
//                    Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//                } catch (NoSuchAlgorithmException e) {
//                    Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
//                }
//            }
//        }
}