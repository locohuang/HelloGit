package com.example.my.hellogit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityResult2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
    }

    public void back(View view) {
        Intent intent = new Intent(this, ActivityForResult.class);
        Bundle bundle = new Bundle();
        bundle.putString("key", "result2");
        intent.putExtras(bundle);
        //setResult(0x113, intent);
        finish();
    }
}
