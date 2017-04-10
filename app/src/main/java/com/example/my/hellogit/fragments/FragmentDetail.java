package com.example.my.hellogit.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.my.hellogit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetail extends Fragment {

    public static String KEY_CITY_NAME = "KEY_CITY_NAME";
    public FragmentDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle !=null && bundle.containsKey(KEY_CITY_NAME)){
            showSelectedCityName(bundle.getString(KEY_CITY_NAME));
        }
    }

    public void showSelectedCityName(String cityName) {
        ((TextView)getView().findViewById(R.id.tv_cityName)).setText(cityName);
    }
}
