package com.example.kbpark.mypagesliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    LinearLayout slidingPanel;
    Button btn;

    Animation translateLeftAnim;
    Animation translateRightAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingPanel = (LinearLayout)findViewById(R.id.slidingPanel);
        btn = (Button) findViewById(R.id.button);

        //로딩하기!
        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim= AnimationUtils.loadAnimation(this, R.anim.translate_right);

        //자 그런데! 실행을 해보면 알겠지만 애니메이션이 끝나서 슬라이딩 되어 나오면,
        //그 다음에 버튼이 '열기'가 아닌 '닫기'로 바뀌게 하고싶어요! 그렇게 하려면 animation이 끝난 시점을 알아야하는데,
        //그 시점의 분기처리를 하기 위해서는 Listener로 접근하면 될거같아요! 한번 해볼게요.
        translateLeftAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override // 시작되는 시점
            public void onAnimationStart(Animation animation) {}

            @Override // 끝나는 시점 - 이때 Button의 text를 바꿀겁니다!
            public void onAnimationEnd(Animation animation) {
                 btn.setText("닫기");
            }

            @Override // 반복되는 시점
            public void onAnimationRepeat(Animation animation) {}
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                slidingPanel.setVisibility(View.VISIBLE);// 가시성 속성을 다시 설정해서 '보이도록 한 후에'
                slidingPanel.startAnimation(translateLeftAnim); // 왼쪽으로 나타나는 애니메이션을 start합니다!
            }
        });

    }
}
