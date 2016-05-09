package com.example.kbpark.mysimplelistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


public class MainActivity extends ListActivity {

    String[] names = {"트와이스","여자친구","AOA","러블리즈"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );

        setListAdapter(adapter);


    }
}


/*
     ListView가 자주 사용되니까 아예 class로 정의되어 있습니다.
     MainActivity를 ListActivity를 상속했습니다!

     < 여기서 중요한 포인트! >
     1. ListView의 id는 반드시 'list'로 해줘야 합니다! id값을 'list'로 찾아오기 때문이죠
     2. onCreate()안에서 자동 inflation해주는 'setContentView()'는 지워줘야 되나보네요.
     3. ListActivity를 상속해서 사용하는 경우 - 화면 전체를 ListView로 띄워야 할 경우인데,
     사실 이런 경우는 실제 앱을 구성할때는 거의 나타나지 않습니다. test용 앱에서는 사용해볼수 있겠네요.

     결론)
        Spinner는 간단한 형태로 구성해도 별로 문제 없지만,
        ListView는 제약사항도 많고 별로 쓸모도 없으니, 직접 MyList1,2,3처럼 class를 구현해서 사용하시는걸 권장합니다.

*/