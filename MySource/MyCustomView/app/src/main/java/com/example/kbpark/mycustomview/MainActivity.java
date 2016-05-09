package com.example.kbpark.mycustomview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        MyLectangle view = new MyLectangle(this);
        container.setBackgroundColor(Color.CYAN);
        container.addView(view);

    }
}
