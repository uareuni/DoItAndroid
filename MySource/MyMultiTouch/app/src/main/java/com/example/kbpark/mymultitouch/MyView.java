package com.example.kbpark.mymultitouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KBPark on 2016. 5. 3..
 */
public class MyView extends View{

    public static final String TAG = "MyView";

    float curX1;
    float curY1;

    float curX2;
    float curY2;


    public MyView(Context context) {
        super(context);

        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)
    {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //MotionEvent객체가 좌표값까지 알수 있게 해줍니다.
        int action = event.getAction();

        int pointerCount = event.getPointerCount(); // 몇개의 손가락으로 터치했는지 알아올수 있습니다. return되는 값으로!

        curX1 = event.getX(0);
        curY1 = event.getY(0);

        if(pointerCount > 1) // 손가락이 한개 이상일때
        {
            curX2 = event.getX(1);
            curY2 = event.getY(1);
        }

        if(action == MotionEvent.ACTION_DOWN) {
            Log.d(TAG,"action_dowm:"+ pointerCount + "/(" + curX1 + "," + curY1 + ") , (" + curX2 + "," + curY2 + ")");
        }else if(action == MotionEvent.ACTION_MOVE){
            Log.d(TAG,"action_move:"+ pointerCount + "/(" + curX1 + "," + curY1 + ") , (" + curX2 + "," + curY2 + ")");
        }else if(action == MotionEvent.ACTION_UP){
            Log.d(TAG,"action_up:"+ pointerCount + "/(" + curX1 + "," + curY1 + ") , (" + curX2 + "," + curY2 + ")");
        }

        return true;
    }
}
