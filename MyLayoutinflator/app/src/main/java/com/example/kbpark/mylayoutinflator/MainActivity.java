package com.example.kbpark.mylayoutinflator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v)
    {
//        LinearLayout container = (LinearLayout)  findViewById(R.id.container);
//        // 여기서 어떻게 찾아줄수 있어요? 위에 setContentView()에서 이미 activity_main을 inflation해주었기 때문에 찾을수 있죠.
//        // 한마디로 main_activity안에 부분 화면을 넣기위한 공간을 마련한 것과 같습니다.
//
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 수동으로 Layout inflation을 해줄수 있게 만들어줘요


        // < 이전 버전 vs 새로운 버젼 >
        // 1. 이전 버젼  : xml단독 layout을
        // 2. 새로운 버젼 : SubLayout 객체를 만들어서 container에 'add' 해줍니다.
        // 공통: 당연한 말이지만 둘다 MainActivity가 아니기때문에 직접 inflation시켜주는 과정이 필요하겠죠?


        // 이전 버젼
        LinearLayout container = (LinearLayout)  findViewById(R.id.container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        container.removeAllViews();  //하나의 container layout에 여러개의 sub layout을 적용시키려면 다음 버튼을 클릭하기전 지워줘야겠네요 이렇게.(한마디로 초기화 과정)

        if(v.getId() == R.id.button){
            Toast.makeText(getApplicationContext(), "Sub1 클릭", Toast.LENGTH_LONG).show();
            inflater.inflate(R.layout.sub_layout, container, true);
            //inflate()의 parameter들 : inflate할때, 1.어떤 xml을, 2.어디다 붙일건가요?, 3.바로 붙일건가요?(true/false)

        }else if(v.getId() == R.id.button3){
            Toast.makeText(getApplicationContext(),"Sub2 클릭",Toast.LENGTH_LONG).show();
            inflater.inflate(R.layout.sub_layout2, container, true);
        }



        // 새로운 버젼 (Flagment로 화면전환)
/*
        SubLayout subLayout = new SubLayout(this);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(subLayout);
*/
          // 뭐 이렇게 줄여서 써도 되겠군요..
//        ((LinearLayout)findViewById(R.id.container)).addView(subLayout);




//            Button btn = (Button) container.findViewById(R.id.button2);
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(), "부분버튼이 눌렸습니다", Toast.LENGTH_LONG).show();
//                }
//            });

    }


}
