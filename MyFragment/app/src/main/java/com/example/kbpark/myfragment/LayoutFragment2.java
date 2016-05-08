package com.example.kbpark.myfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KBPark on 2016. 4. 23..
 */
public class LayoutFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("tag", "onCreateView() - fragment2");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.layout_fragment2,container,false);
        return rootView;
    }
}
