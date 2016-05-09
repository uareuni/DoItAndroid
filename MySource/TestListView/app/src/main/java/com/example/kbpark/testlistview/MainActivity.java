package com.example.kbpark.testlistview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    ListView listView;
    TextView textView;
    String[] numbers = {"1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);

        ListAdapter adapter = new ListAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.i("test","선택되나요?");
                textView.setText(numbers[position]);
            }
        });



    }

    class ListAdapter extends BaseAdapter
    {

        @Override
        public int getCount() { return numbers.length; }

        @Override
        public Object getItem(int position){ return numbers[position]; }

        @Override
        public long getItemId(int position){ return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            TextView view = new TextView(getApplicationContext());
            view.setText(numbers[position]);
            view.setTextColor(Color.BLUE);
            view.setTextSize(20.0f);
            return view;
        }
    }

}
