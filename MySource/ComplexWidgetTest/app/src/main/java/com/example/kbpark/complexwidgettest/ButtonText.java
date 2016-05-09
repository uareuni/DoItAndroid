package com.example.kbpark.complexwidgettest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by KBPark on 2016. 5. 2..
 */
public class ButtonText extends LinearLayout {

    TextView textView;
    Button button;
    String str = button.getText().toString();

    public interface OnButtonText{
        void onButtonText(String str);
    }

    OnButtonText listener;

    public void setOnButtonText(OnButtonText lsnr){
        listener = lsnr;
    }

    //-----------------------------------------------------------------
    public ButtonText(Context context) {
        super(context);

        init(context);
    }

    public ButtonText(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button_text,this,true);

        textView = (TextView) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onButtonText(str);
            }
        });

    }


}
