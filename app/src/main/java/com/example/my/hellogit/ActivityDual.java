package com.example.my.hellogit;

import android.app.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.my.hellogit.fragments.FragmentDetail;
import com.example.my.hellogit.fragments.FragmentMaster;

public class ActivityDual extends Activity {
    boolean dualPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual);
        FragmentMaster fragmentMaster = null;
        FrameLayout frameLayout =
                (FrameLayout)findViewById(R.id.frameLayout);
        if(frameLayout !=null){
            dualPane = false;
            FragmentTransaction transaction =
                    getFragmentManager().beginTransaction();
            fragmentMaster = (FragmentMaster)getFragmentManager().findFragmentByTag("MASTER");
            if(fragmentMaster == null){
                fragmentMaster = new FragmentMaster();
                transaction.add(R.id.frameLayout,fragmentMaster,"MASTER");
            }

            FragmentDetail fragmentDetail = (FragmentDetail)getFragmentManager().findFragmentById(R.id.frameLayout_detail);
            if(fragmentDetail !=null){
                transaction.remove(fragmentDetail);
            }
            transaction.commit();
        }else{
            dualPane = true;
            FragmentTransaction transaction =
                    getFragmentManager().beginTransaction();
            fragmentMaster = (FragmentMaster)getFragmentManager().findFragmentById(R.id.frameLayout_master);
            if(fragmentMaster == null){
                fragmentMaster = new FragmentMaster();
                transaction.add(R.id.frameLayout_master,fragmentMaster);
            }

            FragmentDetail fragmentDetail = (FragmentDetail)getFragmentManager().findFragmentById(R.id.frameLayout_detail);
            if(fragmentDetail ==null){
                fragmentDetail = new FragmentDetail();
                transaction.add(R.id.frameLayout_detail,fragmentDetail);
            }
            transaction.commit();
        }
        fragmentMaster.setOnMasterSelectedListener(new FragmentMaster.OnMasterSelectedListener() {
            @Override
            public void onItemSelected(String cityName) {
                sendCityName(cityName);
            }
        });
    }
    private void sendCityName(String cityName){
        FragmentDetail fragmentDetail;
        if(dualPane){
            fragmentDetail = (FragmentDetail)getFragmentManager().findFragmentById(R.id.frameLayout_detail);
            fragmentDetail.showSelectedCityName(cityName);
        }else{
            fragmentDetail = new FragmentDetail();
            Bundle bundle = new Bundle();
            bundle.putString(FragmentDetail.KEY_CITY_NAME,cityName);
            fragmentDetail.setArguments(bundle);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout,fragmentDetail);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}
