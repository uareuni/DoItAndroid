package com.example.kbpark.mytestcode;

import android.util.Log;

/**
 * Created by KBPark on 2016. 5. 5..
 */
public class Test {

    public static final int ORIGINAL = 0;
    public static final int MATRIX = 1;

    int mode;

    public Test(int mode) {
        this.mode = mode;

        test();
    }

    public void test(){

        if(mode == MATRIX){
            Log.d("test","MATRIX 들어오는데?");
        }
    }
}
