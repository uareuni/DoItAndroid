package com.example.kbpark.mylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        adapter = new SingerAdapter();
        listView.setAdapter(adapter);


    }

    class SingerAdapter extends BaseAdapter {

        // 보통은 이렇게 text형식으로 들어가기보다 ViewGroup이 하나의 item으로 사용되는 경우가 많습니다.
        // 지금 그걸 해볼거에요
        // 그런데 여기서 다 치긴 힘드니까,

        // 그런데, java소스 상에서 layout설정을 해주기엔 코드가 너무 기니까
        // ViewGroup을 정의하는건 layout xml파일에서 해줄게요.


        String[] names = {"트와이스","AOA","여자친구", "러블리즈"};
        String[] ages = {"19","22","18","20"};


        //* 얘네는 ListView가 자동으로 호출해주는 애들이에요.
        @Override  
        //Q) data를 몇개 가지고 있니?
        public int getCount() {
            return names.length; // 이만큼요
        }

        @Override
        //Q) 어떤 item을 call하면 되니?
        //cf) 얘는 매번 호출되겠죠?
        public Object getItem(int position) {
            return names[position]; //이 position(index)에 해당하는를 call해주세요.
        }

        @Override
        // id값을 index로 넣어줘도되요. 그래서 걍 position을 리턴을 해주구요.
        public long getItemId(int position) {
            return position;
        }

        @Override
        // adapter에서 data를 관리하다보니, 들어갈 View도 다 여기서 만들어줘요!
        public View getView(int position, View convertView, ViewGroup parent) {

            // 1. 이렇게 직접 정의해서 해도 되지만 비효율적입니다.
            /*
                TextView view = new TextView(getApplicationContext());
                // 다른 경우에는 activity객체를 넣어줘도 됩니다.
                // UI를 구성하는 View인 경우에는, Activity가 context로 들어갈수가 있겠죠!

                view.setText(names[position]);
                view.setTextSize(20.0f); // 픽셀값이에요
                view.setTextColor(Color.BLACK);
            */

            // 2. 각 view를 위한 별도의 java, xml 세트를 만드시고 이렇게 불러오세요.
            SingerItemView view = new SingerItemView(getApplicationContext());
            view.setName(names[position]);
            view.setAge(ages[position]);


            return view;
        }
    }


}
