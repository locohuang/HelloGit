package com.example.my.hellogit.fragments;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by huangpeiquan on 17/4/9.
 */

public class FragmentMaster extends ListFragment {

    private OnMasterSelectedListener onMasterSelectedListener =null;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String []cityArray = new String[]{"北京市","上海市","广州市","深圳市"};
        ListAdapter cityAdapter = new ArrayAdapter<String>(
                getActivity(),android.R.layout.simple_list_item_1,cityArray
                );
        setListAdapter(cityAdapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(onMasterSelectedListener!=null){
                    onMasterSelectedListener.onItemSelected(((TextView)view).getText().toString());
                }
            }
        });
    }

    public void setOnMasterSelectedListener(OnMasterSelectedListener listener){
        onMasterSelectedListener=listener;
    }
    public interface OnMasterSelectedListener{
        void onItemSelected(String cityName);
    }
}
