package com.example.kbpark.myparcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    public static final String KEY_CODE = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Bundle bundle = getIntent().getExtras();
        Person man = bundle.getParcelable(KEY_CODE);



        String name = man.name;
        int age = man.age;
        Toast.makeText(this,"이름:"+name+"\n나이:"+age,Toast.LENGTH_LONG).show();
    }

    public void onButtonClicked(View v)
    {
        String msg = "잘 받았수다~";
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("msg",msg);


        setResult(RESULT_OK,intent);
        finish();

    }

}
