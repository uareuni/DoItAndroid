package com.example.kbpark.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ium on 14. 2. 25.
 */
public class FragmentTwo extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        Log.i("test","onCreateView()-Fragment2");
        return inflater.inflate(R.layout.fragment_two, container, false);

    }
}