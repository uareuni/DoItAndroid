package com.example.kbpark.myontouchlistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.i("Listener","dispatchTouchEvent() 내부");

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.i("Listener","onTouchEvent() 내부");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

        if (textView != null) {
            textView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    Log.i("Listener","onTouch() 내부");
                    return true;
                }
            });
        }
    }




}
