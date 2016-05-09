package com.example.kbpark.mycomplexwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MultiCheckBox multiCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiCheckBox = (MultiCheckBox) findViewById(R.id.multicheck);


        // 이건 우리가 구현한거죠?
        multiCheckBox.setOnMultiChangeListener(new MultiCheckBox.OnMultiChangeListener() {
            @Override
            public void onMultiChanged(boolean isFirstChecked, boolean isSecondChecked) {
                Toast.makeText(getApplicationContext(),"첫번째: " + isFirstChecked+"두번째: "+isSecondChecked,Toast.LENGTH_LONG).show();
            }
        });

    }
}
