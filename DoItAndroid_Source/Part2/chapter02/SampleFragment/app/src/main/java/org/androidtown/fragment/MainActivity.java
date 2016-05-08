package org.androidtown.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //MainFragment mainFragment;
    MenuFragment menuFragment;
    MenuFragment2 menuFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        Log.i("test","setContentView()-시작");
        setContentView(R.layout.activity_main);
        Log.i("test","setContentView()-끝");
        Log.i("test","------------------------------------- ");

        //mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        //menuFragment = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.menuFragment);
        menuFragment = new MenuFragment();
        menuFragment2 = new MenuFragment2();

/*
        //mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        FragmentManager manager = getSupportFragmentManager();
        if(manager == null){
            Log.i("test","manager객체 null입니다..");
        }

        mainFragment = (MainFragment) manager.findFragmentById(R.id.mainFragment);
        if(mainFragment == null){
            Log.i("test","mainFragment null입니다..");
        }

        menuFragment = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.menuFragment);
*/
       Log.i("test","onCreate()-끝");
     Log.i("test","------------------------------------- ");

    }

    // 왜 얘가 MainFragment클래스 안에서 정의되는것이 아닌
    // MainActivity클래스 안에서 구현할수 있는거지?
    // 분명히 fragment_main을 인플레이션시킨건 MainFragment인데 말야.. 이상하네?????????????????????
    public void onButton1Clicked(View v)
    {

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, menuFragment2).commit();
    }

    public void onButton2Clicked(View v)
    {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, menuFragment).commit();
    }
    /*
    public void onButton1Clicked(View v)
    {

        // 참고로 fragment를 backStack에 저장하고 싶으면 commit하기 바로전에 .addToBackStack(null) 을 해주면 된다.

        //1. 한줄로 써버리기.
        Log.i("test","------------------------------------- ");
        Log.i("test","onButton1Clicked()-시작 ");
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment, menuFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, menuFragment).commit();
        Log.i("test","onButton1Clicked()-끝 ");
        Log.i("test","------------------------------------- ");

        //2. 여러줄로 쓰기
        //FragmentManager manager = getSupportFragmentManager(); //import android.support.v4.app.*; 얘가 import되어 있는지 확인해야 한다!
        //FragmentTransaction fragmentTransaction = manager.beginTransaction();
        //fragmentTransaction.replace(R.id.mainFragment,mainFragment).commit();

    }


    public void onButton2Clicked(View v)
    {
        Log.i("test","------------------------------------- ");
        Log.i("test","onButton2Clicked()-시작 ");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, menuFragment).commit();
        Log.i("test","onButton2Clicked()-끝");
        Log.i("test","------------------------------------- ");
    }


    */
}
