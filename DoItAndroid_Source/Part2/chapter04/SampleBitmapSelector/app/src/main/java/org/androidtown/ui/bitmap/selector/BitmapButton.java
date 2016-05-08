package org.androidtown.ui.bitmap.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by KBPark on 2016. 4. 28..
 */
public class BitmapButton extends Button{
    public BitmapButton(Context context) {
        super(context);

        init();
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();// 터치한 상태를 알아와서,
        if(action == MotionEvent.ACTION_DOWN){
            setBackgroundResource(R.drawable.arrow_left_clicked);
        }else if(action == MotionEvent.ACTION_UP){
            setBackgroundResource(R.drawable.arrow_left_normal);
        }

        return true;
    }

    private void init()
    {
        setBackgroundResource(R.drawable.arrow_left_normal);// 버튼을 만들어지면 이 이미지로 설정이 되겠네요.

    }

}
