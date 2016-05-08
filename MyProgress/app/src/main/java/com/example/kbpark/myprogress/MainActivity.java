package com.example.kbpark.myprogress;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }


    public void onButton1Clicked(View v)
    {
        progressBar.setProgress(50);
    }

    public void onButton2Clicked(View v)
    {
        ProgressDialog dialog = new ProgressDialog(this);// activity 객체를 context로 전달하는.
        //
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 원형 스타일의 프로그래스 다이얼로그
        dialog.setTitle("진행상태");
        dialog.setMessage("데이터를 확인하는 중입니다.");

        dialog.show();
    }

}
