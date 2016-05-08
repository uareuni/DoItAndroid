package org.androidtown.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2015-12-25.
 */
public class MenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.i("tag", "onCreateView() - MenuFrag");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu, container, false);

        Log.i("test","onCreateView()- MenuFragment");

        return rootView;
    }

}
