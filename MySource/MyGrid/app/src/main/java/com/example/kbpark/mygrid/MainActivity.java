package com.example.kbpark.mygrid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    // 얘도 선택위젯이라 껍데기 입니다. 알짜는 Adapter겠죠?
    // gridView는 ListView와 별로 차이가 없습니다.
    // 그래서 추가로 xml상에서 colum, row 속성값을 주지 않으면 ListView로 떠버립니다.
    // android:numColumns="2"
    // 사용예시) 쇼핑몰 사이트 모바일버젼.
    // 물론 실제로 사용할때는 서드파티 라이브러리를 사용해서 예쁘게 구성하겠죠?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        SingerAdapter adapter = new SingerAdapter();
        gridView.setAdapter(adapter);

    }


    class SingerAdapter extends BaseAdapter
    {
        String[] names = {"트와이스","여자친구","AOA","러블리즈"};

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = new TextView(getApplicationContext());
            view.setText(names[position]);
            view.setTextSize(50.0f);
            view.setTextColor(Color.BLUE);

            return view;
        }
    }


}
