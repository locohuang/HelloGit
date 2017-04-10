package com.example.my.hellogit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends Activity {
    private TextView tv_green,tv_yellow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv_green = (TextView)findViewById(R.id.tv_green);
        tv_yellow = (TextView)findViewById(R.id.tv_yellow);
    }
    public void c2(View view){
        if(view.getId() == R.id.btn_1) {
            tv_green.setVisibility(View.VISIBLE);
            tv_yellow.setVisibility(View.INVISIBLE);
        }
        else if(view.getId() == R.id.btn_2) {
            tv_green.setVisibility(View.INVISIBLE);
            tv_yellow.setVisibility(View.VISIBLE);
        }
    }
}
