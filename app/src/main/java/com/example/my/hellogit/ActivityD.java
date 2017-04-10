package com.example.my.hellogit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityD extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
    }
    public void go(View view){
        Intent intent = new Intent(this,ActivityB.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //a b
        //intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT); //a b c d b
        //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //b
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);//a b c d b
        startActivity(intent);
    }
}
