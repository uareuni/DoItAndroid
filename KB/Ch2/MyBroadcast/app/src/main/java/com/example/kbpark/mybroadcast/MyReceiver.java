package com.example.kbpark.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver
{
    private static final String TAG = "MyBroadcastReceiver";

    public MyReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
/*
            Q) Context가 뭐에요?
            - context는 해당 component를 담고있는 '주변정보'에요. 뜻 자체도 '맥락'이란 의미인데,
            예를들어 button이 있으면, 그 상황에서 context객체는 버튼을 담고있는 주변정보인 activity가 context 객체가 됩니다.
            Intent, Button(UI요소)등은 항상 context를 알고 있어야 합니다.
*/


        Log.d(TAG, "onReceive() 호출됨");
/*
            이 상황에서 화면을 하나 띄워볼게요. 뭔가 동작을 하는게 보이면 좋겠으니까요.
            안드로이드에서는 화면이 없는 상태에서 화면을 띄우려면 'Task'라는게 필요해요.
            task는 intent에 flag값으로 줄수 있어요!

*/
        Intent myIntent = new Intent(context, MainActivity.class);
//          onReceive()는 특이하게도 context객체를 parameter로 전달해주네요?
//          그래서 따로 get하지 않아도 될것 같습니다.
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
//            그런데 우리는 화면이 이미 떠있는 상황에서 이렇게 new task 작업을 해주게되면 activity가 겹치는 상황이 발생할수 있으니
//            '|'구분자로 다른 옵션을 하나 더 달아줄겁니다! (-> SINGLE_TOP 옵션)
//
//            앞에서도 잠시 나왔듯 flag에 SINGLE_TOP 속성을 주면 activity가 겹칠경우 중복을 삭제해줍니다.


    }



}
