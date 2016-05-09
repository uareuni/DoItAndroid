package com.example.kbpark.mylist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by KBPark on 2016. 4. 29..
 */
public class SingerItemView extends LinearLayout {

    // 이거랑 대응되는 layout인 singer_item.xml의 최상위 layout이 LinearLayout이니,
    // 여기서도 LinearLayout을 상속해야 합니다!

    TextView nameTextView;
    TextView ageTextView;

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)
    {
        //여기서는 xml layout을 붙여주는 역할을 할거에요 - inflation
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
    }

    public void setName(String name){
         nameTextView.setText(name);
    }

    public void setAge(String age){
        ageTextView.setText(age);
    }

}
