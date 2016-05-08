package com.example.kbpark.myparcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_CODE = "data";
    public static final int REQUEST_CODE_ANOTHER = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v)
    {
        //방법 #1
        Intent intent = new Intent(getApplicationContext(),AnotherActivity.class);
        //방법 #2
//        Intent intent = new Intent();
//        ComponentName name = new ComponentName("com.example.kbpark.myparcelable","com.example.kbpark.myparcelable.Another");
//        intent.setComponent(intent);
        Person man = new Person("박경배",25);
        intent.putExtra(KEY_CODE, man);
        startActivityForResult(intent, REQUEST_CODE_ANOTHER);

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK)
        {
            String msg = data.getStringExtra("msg");
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

}
