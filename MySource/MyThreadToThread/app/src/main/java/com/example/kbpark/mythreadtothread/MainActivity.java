package com.example.kbpark.mythreadtothread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    ProcessThread thread;
    MainHandler mainHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        mainHandler = new MainHandler();
        thread = new ProcessThread();

        thread.start(); // 버튼이 클릭되기 전에 Looper를 돌려놔야 하므로, 얘는 onCreate()에서 실행되는게 맞습니다.
    }

    public void onButtonClicked(View v)
    {
        String inStr = editText.getText().toString();
        Message msg = Message.obtain();
        msg.obj = inStr;

        //Log.i("test","msg.obj : " + msg.obj.toString()); // OK

        thread.processHandler.sendMessage(msg);
    }


    public class ProcessThread extends Thread
    {
        ProcessHandler processHandler;

        public ProcessThread(){
            processHandler = new ProcessHandler();
        }

        @Override
        public void run() {
            // looper를 만들고 세팅하는 과정입니다.
            Looper.prepare();
            Looper.loop();
        }

    }

    public class ProcessHandler extends Handler
    {
        @Override
        // "안녕하세요 저는 작업 Handler인데요,"
        // "main thread님께서 받아서 이걸 처리해주셨으면 해요"
        public void handleMessage(Message msg)
        {
            Message resultMsg = Message.obtain();
            resultMsg.obj = msg.obj + " Hello!";

            // Log.i("test","resultMsg.obj : " + resultMsg.obj.toString()); // ok

            mainHandler.sendMessage(resultMsg);
        }
    }

    public class MainHandler extends Handler
    {
        @Override
        // "안녕하세요 저는 MainHandler인데요,"
        // "작업 thread님께서 받아서 이걸 처리해주셨으면 해요"
        public void handleMessage(Message msg)
        {
            String text = (String) msg.obj;
            editText2.setText(text);
        }
    }

}

