package com.example.kbpark.mylayoutinflator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by KBPark on 2016. 4. 18..
 */
public class SubLayout extends LinearLayout{


    // 먼저 할 일은, sub_layout.xml을 이 java파일에 붙여줘야되요!
    // activity_main을 MainActivity에 'setContentView()'로 붙여준것 처럼요!
    // 언제붙여주냐면 객체로 만들어지는 시점에 붙여주면 됩니다. constructor에서요.

    // < contructor는 반드시 2개를 만들어줘야해요. >
    //1. 얘는 java 소스 상에서 new로 객체를 만들때 사용될 constructor구요
    public SubLayout(Context context) {
        super(context);

        init(context);
    }
    //2. 얘는 xml TAG를 추가할 경우 호출될 constructor입니다.
    public SubLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // 이 안에서 inflation을 하도록 해줄겁니다. 직접해주는 방법을 써야겠죠?
    private void init(Context context)
    {
        // 수동 inflation을 통해 xml파일을 이 java소스에 붙여주는 작업을 합니다.

        // 여기서 중요한건 받아온 context객체(->MainActivity)의 getSystemServer()를 call한다는 겁니다!
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub_layout, this, true);

    }


}
