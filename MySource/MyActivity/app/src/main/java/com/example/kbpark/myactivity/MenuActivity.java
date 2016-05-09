package com.example.kbpark.myactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();// 시작할때 받아보려구요.
        if(intent !=  null)
        {
            String title = intent.getStringExtra("title");
            Toast.makeText(getApplicationContext(), "전달받은 값 : " + title, Toast.LENGTH_LONG).show();
        }
    }

    public void onButton1Clicked(View v)
    {

        Intent intent = new Intent();
        // 얘는 (앞에서와 다르게) getApplicationContext()를 파라미터로 넘길필요가 없겠죠. 왜냐면 다른 activity를 참조하려는게 아니니까 Activity src가 필요없어서.
        // getApplicationContext()로 context를 받아와야 Activity간에 resource를 공유할수 있다는거 알고 계시죠? ^^ㅎ

        intent.putExtra("name","트와이스");
        setResult(RESULT_OK,intent); //여기도 코드를 넣어줘야하는데 result가 정상일때 사용하는 상수가 정의되어 있어요.

        finish();
    }
}
