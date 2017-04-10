package com.example.my.hellogit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityFrameLayout extends Activity {
    private TextView tv_green,tv_yellow;
    private Button btn_green,btn_yellow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        //tv_green = (TextView)findViewById(R.id.tv_green);
        //tv_yellow = (TextView)findViewById(R.id.tv_yellow);

    }
    public void c1(View view){
        if(view.getId() == R.id.btn_green){

            System.out.println("green");
        }else if(view.getId() == R.id.btn_yellow){
            System.out.println("yellow");
        }
    }
    /*public void change(View view){
        if(view.getId() == R.id.btn_green){
            tv_green.setVisibility(View.VISIBLE);
            tv_yellow.setVisibility(View.INVISIBLE);
        }else if(view.getId() == R.id.btn_yellow){
            tv_green.setVisibility(View.INVISIBLE);
            tv_yellow.setVisibility(View.VISIBLE);
        }
    }*/
}
