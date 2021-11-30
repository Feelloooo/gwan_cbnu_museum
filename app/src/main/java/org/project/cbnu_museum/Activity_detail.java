package org.project.cbnu_museum;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_detail extends AppCompatActivity {

    TextView mTitleTv, mEraTv,mPlaceTv, mDescTv,mDetailTv;
    ImageView mImageIv;
    // MediaPlayer 객체생성
    MediaPlayer mediaPlayer;

    // 시작버튼
    Button startButton,stopButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitleTv = findViewById(R.id.title);
        mEraTv = findViewById(R.id.era);
        mPlaceTv = findViewById(R.id.place);
        mDescTv = findViewById(R.id.description);
        mDetailTv = findViewById(R.id.detail);
        mImageIv = findViewById(R.id.imageView);

        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mEra = intent.getStringExtra("iEra");
        String mPlace = intent.getStringExtra("iPlace");
        String mDescription = intent.getStringExtra("iDesc");
        String mDetail = intent.getStringExtra("iDetail");

        startButton = (Button)findViewById(R.id.s);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 플레이 중이라면

                if(mediaPlayer != null &&  mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;

                    // reset() 함수만으로도 동작한다.
                    //mediaPlayer.reset();
                    startButton.setText("▶ 재생하기");
                }
                else // 미디어 리소스를 생성하고 플레이 시킨다.
                {
                    if(mTitle.equals("물고기모양 예술품")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m1);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("흥수아이 1호")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m2);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("슴베찌르개")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m3);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("들소머리 예술품")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m4);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("얼굴모양 예술품")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m5);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("찌르개")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m6);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("주먹도끼")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m7);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("상아")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m8);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("쌍코뿔이")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m9);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else if(mTitle.equals("동굴곰")) {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.m10);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }
                    else {
                        mediaPlayer = MediaPlayer.create(Activity_detail.this, R.raw.s);
                        mediaPlayer.start();
                        // 반복재생하기
                        mediaPlayer.setLooping(true);
                        startButton.setText("종료 하기");
                    }

                }
            }
        });


        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);

        mTitleTv.setText(mTitle);
        mEraTv.setText(mEra);
        mPlaceTv.setText(mPlace);
        mDescTv.setText(mDescription);
        mDetailTv.setText(mDetail);
        mImageIv.setImageBitmap(bitmap);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}