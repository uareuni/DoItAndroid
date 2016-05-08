package com.example.kbpark.myspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String[] names = {"트와이스","여자친구","AOA"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        
        // 이번에는 BaseAdapter를 상속한 class를 만들지 않고 미리 정의된걸 사용해볼게요.간편하게.
        //ArrayAdapter는 자주 사용하는 adapter입니다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, //android.R - 안드로이드 API에서 제공하는 리소스를 쓰겠다는 겁니다.
                names // 문자열 배열을 그대로 넣어줍니다.
        );

        spinner.setAdapter(adapter);


        // 임의의 item하나가 선택됬을때 어떤 작업을 해주고 싶으면 이렇게 하면되요.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"선택된 아이템:"+names[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
