package com.example.kbpark.mycomplexwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/**
 * Created by KBPark on 2016. 5. 2..
 */
public class MultiCheckBox extends LinearLayout{

    // 우리는 이 복합위젯을 결국 최종적으로 activity_main에 붙여줄것이기 때문에,
    // MainActivity에서 얘를 사용할수 있도록 하기 위한 작업을 추가적으로 해줘야합니다.
    // 우린 외부에서 접근할수 있도록 하는 interface를 하나 새로 정의해볼거에요.

    // tip) onClickListener를 사용하는거랑 똑같이 MainActivity에서 사용할수 있도록
    //     여기서 정의해 놓는거라고 생각하세요. (사실 다른 Listener들도 이렇게 정의되어 있을겁니다)

    // 이 방법을 꼭 잘 알아두시는게 좋습니다.
    // 왜냐면, Fragment에서 이벤트 처리하는 방식도 이거랑 똑같습니다. 이렇게 해요!



    public interface OnMultiChangeListener
    {
        void onMultiChanged(boolean isFirstChecked, boolean isSecondChecked);
    }

    public void setOnMultiChangeListener(OnMultiChangeListener lsnr)
    {
        // 얘는 장착용 메소드 : 기능까지 다 구현해 일회성으로 뚝딱 만든 임시객체 하나를, 본래 객체에 장착해주는 역할!
        listener = lsnr;
    }


//------------------------------------------------------------------------------------------------------
    OnMultiChangeListener listener; // 본래 객체 입장에서 볼때 얘는 임시객체

    CheckBox checkBox1;
    CheckBox checkBox2;


    public MultiCheckBox(Context context) {
        super(context);

        init(context);
    }

    public MultiCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.multi_checkbox,this,true);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);


        //checkBox1
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { //얘는 안드로이드 메소드
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(listener != null)
                {
                    // 내가 새로 정의한 함수.
                    // 2개의 체크정보를 넘기기 위해 다시 정의한거다.
                    // (checkBox2의 정보는 직접 받아와야 함.)
                    listener.onMultiChanged(isChecked,checkBox2.isChecked());
                }
            }
        });

        //checkBox2
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { //얘는 안드로이드 메소드
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(listener != null)
                {
                    listener.onMultiChanged(checkBox1.isChecked(),isChecked);
                }
            }
        });
    }

}
