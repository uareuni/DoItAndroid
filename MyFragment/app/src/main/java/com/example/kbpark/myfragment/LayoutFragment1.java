package com.example.kbpark.myfragment;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KBPark on 2016. 4. 23..
 */
public class LayoutFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("tag","onCreateView() - fragment1");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.layout_fragment1,container,false);
        return rootView;
    }
}
