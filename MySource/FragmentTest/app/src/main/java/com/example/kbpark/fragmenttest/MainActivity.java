package com.example.kbpark.fragmenttest;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    FragmentManager fm = getFragmentManager();
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
    }

    public void selectFrag(View view){
        //Fragment fr;

        fragmentTransaction = fm.beginTransaction();


        if(view == findViewById(R.id.button2)){
            //fr = new FragmentTwo();
            fragmentTransaction.replace(R.id.fragment_place, fragmentTwo);
            fragmentTransaction.commit();
            Log.i("test","button2 끝");
        }else {
            //fr = new FragmentOne();
            fragmentTransaction.replace(R.id.fragment_place, fragmentOne);
            fragmentTransaction.commit();
            Log.i("test","button1 끝");
        }



        //Log.i("test","2");
        //fragmentTransaction.replace(R.id.fragment_place, fr);
        //Log.i("test","3");


        //fragmentTransaction.commit();


        //Log.i("test","4");
    }



}
