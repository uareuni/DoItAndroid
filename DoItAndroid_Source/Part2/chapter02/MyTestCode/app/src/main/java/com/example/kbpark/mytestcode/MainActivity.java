package com.example.kbpark.mytestcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int ORIGINAL = 0;
    public static final int MATRIX = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    int mode;

    public void onButtonClicked(View v)
    {
        if(v.getId() == R.id.original){
            Test test1 = new Test(ORIGINAL);
            setContentView(R.layout.activity_main);
        }else if(v.getId() == R.id.back){
            Test test1 = new Test(MATRIX);
            setContentView(R.layout.activity_main);
        }
    }




}
