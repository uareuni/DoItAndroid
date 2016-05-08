package com.example.kbpark.complexwidgettest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    ButtonText buttonText;
    //TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonText = (ButtonText) findViewById(R.id.button_text);
        //textView = (TextView) findViewById(R.id.editText);


        if(buttonText == null){
            Log.d("test","str이 null");
        }
        buttonText.setOnButtonText(new ButtonText.OnButtonText() {
            @Override
            public void onButtonText(String str) {

                //textView.setText(str);
            }
        });
    }



}
