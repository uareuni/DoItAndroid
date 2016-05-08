package com.example.kbpark.mypager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);

        MyAdapter adapter = new MyAdapter();
        pager.setAdapter(adapter);

    }

    public void onButton1Clicked(View v){
        pager.setCurrentItem(1);// 두번째 화면으로 이동하도록 해볼게요!
    }


    //Activity는 바뀌지 않습니다! 그래서 여러분이 직접 화면을 더하고, 빼고 하는등 관리를 해줘야 합니다.
    //각각의 화면을 fragment로 활용할수 있는데 꼭 해보세요!
    // -> instantiateItem()에서 계속 FragmentTransaction()을 실행시켜 만들면 되겠네

    // 얘는 '선택 위젯' 이라고 뒤에서 배울건데요,
    // Adapter라는게 필요해요. 일단은 그냥 해보세요~
    class MyAdapter extends PagerAdapter{

        String[] names = {"소녀시대","걸스데이","시스타"};

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        // 이 메소드는 화면을 넘길때마다 불리겠군요!
        // 여기서 각각의 화면을 직접 만들어줄겁니다. 각각의 index에 맞는 화면을 만들어 줄거에요.
        // position: index를 가리킵니다
        // 각각 index에 맞는 화면을 만들어 볼겁니다.
        public Object instantiateItem(ViewGroup container, int position) {
            LinearLayout layout = new LinearLayout(getApplicationContext()); // 파라미터로 getApplicationContext()를 넣어주네?
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView view = new TextView(getApplicationContext());// 파라미터로 getApplicationContext()를 넣어주네? 여기도?
            view.setText(names[position]);//화면을 넘길때마다 이 메소드가 call되어야만 의미가 있음을 알수 있습니다.
            view.setTextSize(40.0f);

            layout.addView(view);

            container.addView(layout);

            return layout;
        }

    }

}
