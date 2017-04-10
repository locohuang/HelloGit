package com.example.my.hellogit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityResult extends Activity {
    private EditText myet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        myet = (EditText) findViewById(R.id.myet);
        System.out.println("#:"+getClass().getSimpleName() + ":onCreat");
        myet.setText(getIntent().getStringExtra("mykey1"));
    }

    public void back(View view) {
        Intent intent = new Intent(this, ActivityForResult.class);
        intent.putExtra("myet", myet.getText().toString());
        setResult(0x112, intent);
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("#:"+getClass().getSimpleName() + ":onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("#:"+getClass().getSimpleName() + ":onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("#:"+getClass().getSimpleName() + ":onResume");
    }

    @Override
    protected void onPause() {
        System.out.println("#:"+getClass().getSimpleName() + ":onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("#:"+getClass().getSimpleName() + ":onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("#:"+getClass().getSimpleName() + ":onDestroy");
        super.onDestroy();
    }
}