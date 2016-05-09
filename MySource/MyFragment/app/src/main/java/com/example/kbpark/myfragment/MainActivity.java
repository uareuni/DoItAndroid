package com.example.kbpark.myfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity{
    LayoutFragment1 layoutFragment1;
    LayoutFragment2 layoutFragment2;

    FragmentManager fm = getFragmentManager();
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutFragment1 = new LayoutFragment1();
        layoutFragment2 = new LayoutFragment2();
    }

    public void onButton1Clicked(View v)

    {
        fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, layoutFragment1);// 두번째 인자로 fragment를 달라는거 보니 얘는 fragment가 아니었다????
        fragmentTransaction.commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment, layoutFragment1).commit();
    }

    public void onButton2Clicked(View v)
    {
        fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, layoutFragment2);
        fragmentTransaction.commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment, layoutFragment2).commit();
    }
}
