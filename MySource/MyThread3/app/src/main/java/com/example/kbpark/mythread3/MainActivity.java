package com.example.kbpark.mythread3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ProcessThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thread = new ProcessThread();
        thread.start();
    }

    public void onButtonClicked(View v)
    {
        thread.processHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("tag","메인 스레드 -> 새로운 스레드");
            }
        });
    }

    class ProcessThread extends Thread
    {
        Handler processHandler = new Handler();
        // 이 Thread안의 Handler를 정의해볼게요!
        // 여태껏 만든 handler는 main_thread의 handler였죠?

        public ProcessThread()
        {

        }

        public void run()
        {
            // 별도의 handler를 쓰려면 내부적으로 돌아가야하는 Looper라는것도 수동으로 세팅해줘야 합니다.
            // (수동으로 inflation시켜주는거랑 비슷하네)
            // 이렇게 하면, 들어오는 정보를 처리할수 있게(handler가 동작할수 있게) 내부적으로 구성이 됩니다
            Looper.prepare();
            Looper.loop();

            for(int i=0; i<20; i++)
            {
                Log.d("tag","스레드 동작중 : #" + i);
                SystemClock.sleep(1000);
            }
        }
    }
}
