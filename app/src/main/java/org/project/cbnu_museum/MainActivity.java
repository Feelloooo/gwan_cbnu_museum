package org.project.cbnu_museum;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    ViewFlipper v_fllipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();

        Button button = (Button) dialog.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

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
                Intent intent = new Intent(getApplicationContext(), Activity_intro.class);
                startActivity(intent);
            }
        });

        //층별안내
        Button button2 = findViewById(R.id.menu2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_heritage.class);
                startActivity(intent);
            }
        });
        Button button3 = findViewById(R.id.menu3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_floor_info.class);
                startActivity(intent);
            }
        });
        Button button4 = findViewById(R.id.menu4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_program.class);
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

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
            ActivityCompat.finishAffinity(this);
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "종료하시려면 뒤로가기를 눌러주세요.", Toast.LENGTH_SHORT).show();
        }
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