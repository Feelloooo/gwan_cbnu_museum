package org.project.cbnu_museum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_fllipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}