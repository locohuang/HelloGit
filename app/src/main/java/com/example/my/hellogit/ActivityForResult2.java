package com.example.my.hellogit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityForResult2 extends Activity {
    private TextView mytv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result2);
        mytv = (TextView)findViewById(R.id.mytv);

    }
    public void get(View view){

            Intent intent = new Intent(this, ActivityResult.class);
            intent.putExtra("mykey2","send2");
            startActivityForResult(intent, 0x110);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==0x112 ){
            mytv.setText(data.getStringExtra("myet"));
        }
        if(resultCode==0x113){
            mytv.setText(data.getExtras().getString("key"));
        }


    }
}
