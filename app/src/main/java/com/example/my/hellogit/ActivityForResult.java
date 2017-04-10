package com.example.my.hellogit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityForResult extends Activity {
    private TextView mytv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);
        mytv = (TextView)findViewById(R.id.mytv);
        System.out.println("#:"+getClass().getSimpleName()+":onCreat");
    }
    public void get(View view){
        if(view.getId()==R.id.btn1) {
            Intent intent = new Intent(this, ActivityResult.class);
            intent.putExtra("mykey1","send1");
            startActivityForResult(intent, 0x110);
            //System.out.println("msg:启动activity之后执行！");

        }
        if(view.getId()==R.id.btn2) {
            Intent intent = new Intent(this, ActivityResult2.class);
            startActivityForResult(intent, 0x111);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0x110){

            mytv.setText(data.getStringExtra("myet"));
            //startActivity(new Intent(this,MainActivity.class));
        }
        if(requestCode==0x111){
            mytv.setText("no");
        }
        /*if(resultCode==0x112 ){
            mytv.setText(data.getStringExtra("myet"));
        }
        if(resultCode==0x113){
            mytv.setText(data.getExtras().getString("key"));
        }*/


    }
    public void showDialog(View view){
      AlertDialog dialog  = new AlertDialog.Builder(this)
                .setTitle("这是dialog")
                .setMessage("这是消息显示")
                .setIcon(R.mipmap.ic_launcher)
                .create();
        dialog.show();

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("#:"+getClass().getSimpleName()+":onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("#:"+getClass().getSimpleName()+":onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("#:"+getClass().getSimpleName()+":onResume");
    }

    @Override
    protected void onPause() {
        System.out.println("#:"+getClass().getSimpleName()+":onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("#:"+getClass().getSimpleName()+":onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("#:"+getClass().getSimpleName()+":onDestroy");
        super.onDestroy();
    }
}
