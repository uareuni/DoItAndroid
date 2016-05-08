package com.example.kbpark.mylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SingerAdapter adapter;



    String[] names = {"트와이스","AOA","여자친구", "러블리즈","5","6","7","8","9","10","11"};
    String[] ages = {"1","2","3","4","5","6","7","8","9","10","11"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        adapter = new SingerAdapter();


        for(int i=0; i<names.length; i++)
        {
            adapter.addItem(new SingerItem(names[i], ages[i]));
        }

        listView.setAdapter(adapter);


    }

    class SingerAdapter extends BaseAdapter {

        // 보통은 이렇게 text형식으로 들어가기보다 ViewGroup이 하나의 item으로 사용되는 경우가 많습니다.
        // 지금 그걸 해볼거에요
        // 그런데 여기서 다 치긴 힘드니까,


        // 그런데, java소스 상에서 layout설정을 해주기엔 코드가 너무 기니까
        // ViewGroup을 정의하는건 layout xml파일에서 해줄게요.



        // 그런데 이제는 들어가는 data마져 하나의 객체가 들어가도록 해볼게요.
        // 그걸 위해서 SingerItem.java class를 만들거에요.
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
            // ArrayList의 성능을 위해서라도, type을 지정해주는게 좋아요!


        // 이제 data는 adapter랑 독립적으로 움직이게 되었으니,
        // adapter밖에서 data를 추가할수 있는 메소드가 필요하겠네요!
        public void addItem(SingerItem item)
        {
            items.add(item);
        }


        //* 얘네는 ListView가 자동으로 호출해주는 애들이에요.
        @Override  
        //Q) data를 몇개 가지고 있니?
        public int getCount() {
            return items.size(); // 이만큼요 //arrayList의 길이는 size()로 !!
        }

        @Override
        //Q) 어떤 item을 call하면 되니?
        //cf) 얘는 매번 호출되겠죠?
        public Object getItem(int position) {
            return items.get(position); //이 position(index)에 해당하는를 get해주는 메소드!
        }

        @Override
        // id값을 index로 넣어줘도되요. 그래서 걍 position을 리턴을 해주구요.
        public long getItemId(int position) {
            return position;
        }

        @Override
        // adapter에서 data를 관리하다보니, 들어갈 View도 다 여기서 만들어줘요!
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
                 *  convertView의 역할 - 메모리를 절약할 수 있어요.
                 : 만약에 list의 갯수가 많고, 이미지를 로딩하는 경우가 많으면 버벅거림이 발생하게 됩니다.
                 그런데 이때 convertView가 호출됩니다. 로딩은 됬지만 화면상에 안보이는 item(view)들이
                 convertView 파라미터로 자동불리게 됩니다. 따라서 위에 view들을 '재사용'해서 새로 불리게 되는
                 item들로 불러주면 메모리 버벅거림을 크게 줄일수 있고 이는 거의 필수 과정입니다.

                 이렇게 처리해주시면 되요.
            */

            SingerItemView view = null;
            if(convertView == null){ // 아직 화면상에 안쓰는 view가 없는 경우죠
                view = new SingerItemView(getApplicationContext());
            }else{
                view = (SingerItemView) convertView;
                String temp = ((SingerItemView)convertView).ageTextView.getText().toString();
                //Toast.makeText(getApplicationContext(), temp , Toast.LENGTH_LONG).show();
                Log.i("test",temp);
            }


            //---------------------------------------------------------------------------------
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


            SingerItem curItem = items.get(position);

            view.setName(curItem.getName());
            view.setAge(curItem.getAge());


            return view;
        }
    }


}
