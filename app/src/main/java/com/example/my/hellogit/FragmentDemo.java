package com.example.my.hellogit;

import android.app.Activity;



import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.my.hellogit.fragments.FragmentOne;
import com.example.my.hellogit.fragments.FragmentTwo;

public class FragmentDemo extends Activity {
    private Fragment fragmentOne;
    private FragmentTwo fragmentTwo;
    private int showFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        Bundle bundle = new Bundle();
        bundle.putString("key_green","green");
        fragmentOne.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame_main,fragmentOne);
        transaction.commit();
        //getFragmentManager().beginTransaction().add(R.id.frame_main,fragmentOne).commit();

    }

    public void change(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(showFragment==0){
            /*Bundle bundle = new Bundle();
            bundle.putString("key_yellow","yellow");
            fragmentTwo.setArguments(bundle);
            */
            fragmentTwo.setStr("abc");
            transaction.replace(R.id.frame_main,fragmentTwo);

            showFragment = 1;
        }else if(showFragment==1){
            Bundle bundle = new Bundle();
            bundle.putString("key_green","green");
            fragmentOne.setArguments(bundle);
            transaction.replace(R.id.frame_main,fragmentOne);
            showFragment = 0;
        }

        transaction.commit();
    }
}
