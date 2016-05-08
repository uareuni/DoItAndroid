package com.example.kbpark.mylist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
        String[] names = {"트와이스","AOA","여자친구", "러블리즈"};

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
            TextView view = new TextView(getApplicationContext());
            // 다른 경우에는 activity객체를 넣어줘도 됩니다.
            // UI를 구성하는 View인 경우에는, Activity가 context로 들어갈수가 있겠죠!

            view.setText(names[position]);
            view.setTextSize(20.0f); // 픽셀값이에요
            view.setTextColor(Color.BLACK);


            return view;
        }
    }


}
