package com.example.kbpark.myactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onButton1Clicked(View v)
    {
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        intent.putExtra("title", "AOA");
        startActivityForResult(intent, 1001); //요청코드를 또 적어줘야하는데요, 내가 누구한테 요청을 한건지 구분해주는 역할을 합니다.
    }


    @Override //Intent로 오는 값을 받기위해 Generate해서 함수를 오버라이딩 해줘야해요.
    protected void onActivityResult(int requestCode, int resultCode, Intent data) //이 메소드는 MenuActivity에서 보낸 intent를 받아서 사용하기 위해 정의돈 메소드에요!
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "전달받은 값" + name, Toast.LENGTH_LONG).show();
        }


    }


}
