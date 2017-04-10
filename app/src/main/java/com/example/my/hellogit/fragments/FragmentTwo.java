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
public class FragmentTwo extends Fragment {
    TextView tv_two;
    public static String abc="abc";
    String str="1111";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_two = (TextView)view.findViewById(R.id.tv_two);
        tv_two.setText(str);
        /*Bundle bundle = getArguments();
        tv_two.setText(bundle.getString("key_yellow"));*/
    }
    public void setStr(String str){

        this.str = str;
    }
}
