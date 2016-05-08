package com.example.kbpark.mythread;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

// 2. 이번에도 UI Component에 접근하기 위해서 Handler를 사용하는건 변함이 없습니다.
//   다만 이번에는 Handler클래스를 상속받은 새로운 class를 정의하는게 아니라,
//   기존에 정의된 Handler클래스 자체를 사용할 거에요!
//   이렇게 하면 새로운 클래스를 정의할 필요도 없고, 코드도 훨씬 간결해져요! (얘는 Runnable 인터페이스 일회적으로 구현하는 방법을 같이 사용합니다.)
public class MainActivity extends AppCompatActivity {

    TextView textView;
    //ResponseHandler handler = new ResponseHandler();

    //2. 기본 핸들러를 사용할겁니다!
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClicked(View v)
    {
        textView = (TextView) findViewById(R.id.textView);

        RequestThread thread = new RequestThread();
        thread.start();
    }


    class RequestThread extends Thread
    {
        @Override
        public void run()
        {
            for(int i=0; i<20; i++)
            {
                SystemClock.sleep(500);
                printData(""+i);
            }
        }



        // < final로 만드는 테크닉 > - 잘 정리해두세요! 내부에서 data를 접근할수 있게 하기위한 방법중 하나입니다. (물론 위에다가 Global변수로 만들어놔도 됩니다.)
        public void printData(final String data)
        {
            /*
            //textView.setText(data); //이렇게 직접 접근 못해요.
            Message msg = handler.obtainMessage();

            Bundle bundle = new Bundle();
            bundle.putString("data",data); // bundle에 넣기(packaging)

            msg.setData(bundle); //메시지에는 data를 set해서 실어서 보내게 됩니다.

            //handler.sendMessage(msg);
            */

            handler.post(new Runnable() { // post : 던진다
                @Override
                public void run() {
                    // handler가 순서대로 처리할수 있도록 한 다음에, 이 안에 코드가 실행되고 main thread안에서 실행되게 됩니다.
                    // sendMessage()따로 하지 않아도 post만 해주면 다 알아서 해줘요.
                    // 따라서 여기 안에서는 UI Component에 마음대로 접근할 수 있어요!
                    textView.setText(data);
                }
            });

        }
    }

/*
    // 그런다음 여기서 msg를 받으면, 순서대로 처리할수 있도록 얘가 자체적으로 정리한 후에 (순서정리)
    // handleMessage() - 즉, 메시지를 다루게 됩니다.
    class ResponseHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg) {

            Bundle bundle = msg.getData();
            String data = bundle.getString("data"); // bundle에서 꺼내기(un-packaging)

            textView.setText(data);
        }
    }
*/
}
