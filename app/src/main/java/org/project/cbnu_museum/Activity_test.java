package org.project.cbnu_museum;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Activity_test extends AppCompatActivity {

    public ArrayList<User> userList;
    ImageView imageView1, imageView2, imageView3, imageView4;

    Bitmap bitmap1, bitmap2, bitmap3, bitmap4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        imageView1 = (ImageView)findViewById(R.id.test_imageview1);
        imageView2 = (ImageView)findViewById(R.id.test_imageview2);
        imageView3 = (ImageView)findViewById(R.id.test_imageview3);
        imageView4 = (ImageView)findViewById(R.id.test_imageview4);

        initLoadDB();   //데이터베이스 로딩

        // 안드로이드에서 네트워크와 관련된 작업을 할 때,
        // 반드시 메인 Thread가 아닌 별도의 작업 Thread를 생성하여 작업해야 한다.
        Thread mThread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url1 = new URL(userList.get(0).getAddress());
                    URL url2 = new URL(userList.get(1).getAddress());
                    URL url3 = new URL(userList.get(2).getAddress());
                    URL url4 = new URL(userList.get(3).getAddress());

                    // Web에서 이미지를 가져온 뒤
                    // ImageView에 지정할 Bitmap을 만든다
                    HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
                    conn1.setDoInput(true); // 서버로 부터 응답 수신
                    conn1.connect();

                    HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
                    conn2.setDoInput(true); // 서버로 부터 응답 수신
                    conn2.connect();

                    HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
                    conn3.setDoInput(true); // 서버로 부터 응답 수신
                    conn3.connect();

                    HttpURLConnection conn4 = (HttpURLConnection) url4.openConnection();
                    conn4.setDoInput(true); // 서버로 부터 응답 수신
                    conn4.connect();

                    InputStream is1 = conn1.getInputStream(); // InputStream 값 가져오기
                    bitmap1 = BitmapFactory.decodeStream(is1); // Bitmap으로 변환

                    InputStream is2 = conn2.getInputStream(); // InputStream 값 가져오기
                    bitmap2 = BitmapFactory.decodeStream(is2); // Bitmap으로 변환

                    InputStream is3 = conn3.getInputStream(); // InputStream 값 가져오기
                    bitmap3 = BitmapFactory.decodeStream(is3); // Bitmap으로 변환

                    InputStream is4 = conn4.getInputStream(); // InputStream 값 가져오기
                    bitmap4 = BitmapFactory.decodeStream(is4); // Bitmap으로 변환

                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        mThread.start(); // Thread 실행

        try {
            // 메인 Thread는 별도의 작업 Thread가 작업을 완료할 때까지 대기해야한다
            // join()를 호출하여 별도의 작업 Thread가 종료될 때까지 메인 Thread가 기다리게 한다
            mThread.join();

            // 작업 Thread에서 이미지를 불러오는 작업을 완료한 뒤
            // UI 작업을 할 수 있는 메인 Thread에서 ImageView에 이미지를 지정한다
            imageView1.setImageBitmap(bitmap1);
            imageView2.setImageBitmap(bitmap2);
            imageView3.setImageBitmap(bitmap3);
            imageView4.setImageBitmap(bitmap4);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TextView text1;
        text1 = (TextView) findViewById(R.id.test_textview1);
        text1.setText(userList.get(0).getName());

        TextView text2;
        text2 = (TextView) findViewById(R.id.test_textview2);
        text2.setText(userList.get(0).getName());

        TextView text3;
        text3 = (TextView) findViewById(R.id.test_textview3);
        text3.setText(userList.get(0).getName());

        TextView text4;
        text4 = (TextView) findViewById(R.id.test_textview4);
        text4.setText(userList.get(0).getName());


    }

    private void initLoadDB() {

        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        userList = mDbHelper.getTableData();

        // db 닫기
        mDbHelper.close();
    }

}