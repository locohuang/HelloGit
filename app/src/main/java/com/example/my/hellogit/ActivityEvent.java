package com.example.my.hellogit;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityEvent extends Activity /*implements View.OnClickListener*/{
    private Button mybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mybtn = (Button)findViewById(R.id.mybtn);
        //mybtn.setOnClickListener(this);

        OnButtonClickListener onButtonClickListener =new OnButtonClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"aaaa",Toast.LENGTH_SHORT).show();
            }
        };

        mybtn.setOnClickListener(onButtonClickListener);

    }

    /*@Override
    public void onClick(View view) {
        AlertDialog.Builder dialog =new  AlertDialog.Builder(ActivityEvent.this);
        dialog.setTitle("my").create().show();
    }*/

    interface OnButtonClickListener extends View.OnClickListener{
        void onClick(View view);
    }
}
