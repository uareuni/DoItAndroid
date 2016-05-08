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
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.i("tag","onCreateView() - MainFrag");
        // 여기서 받은 rootView는 MainActivity에서 얘가 inflation된 부분영역을 말하는것 같다.
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Log.i("test","onCreateView()- MainFragment");

        return rootView;
    }

}

