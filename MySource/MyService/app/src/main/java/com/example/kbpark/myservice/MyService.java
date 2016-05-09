package com.example.kbpark.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
    private static final String TAG = "MyService";

    public MyService() {
    }
    //아까 '수명주기' check할때는 call back 메소드를 Toast로 찍어서 확인했었는데요
    //'Service'는 화면이 없기때문에 Log를 찍어서 확인해 볼겁니다.

    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate()호출됬넹~"); //tag: 어디서 찍는거냐? 'MyService'에서 찍는겁니다.
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy()호출됬넹~");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand()호출됬넹~");


        if(intent != null)
        {
            String command = intent.getStringExtra("command");
            if(command != null)
            {
                if(command.equals("start")){
                    PrintThread thread = new PrintThread();
                    thread.start();
                }

            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    class PrintThread extends Thread
    {
        public void run()
        {
            for(int i=0; i<20; i++)
            {
                Log.d("TAG", "#" + i + "번 서비스에서 반복됨");

                try {
                    Thread.sleep(500);
                }catch(Exception e){
                    e.getStackTrace();
                }
            }
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
