package com.example.my.hellogit;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ActivityActionBar extends Activity {
    private EditText et;

    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        et = (EditText)findViewById(R.id.et);
        /*Intent intent = new Intent();
        intent.setClassName("com.example.my.webapplication","com.example.my.webapplication.MainActivity");
        startActivity(intent);*/
       /* Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"13533886446"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);*/
        calendar = Calendar.getInstance();

    }
    public void showMe(View v){
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.baidu.com")));
    }
    public void next(View view){
        Intent intent = new Intent(this,ActivityListView.class);
        intent.putExtra("mykey1","myValue");
        intent.putExtra("myDouble1",23.25);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("123");
        arrayList.add("abc");
        arrayList.add("工贸");
        intent.putStringArrayListExtra("myStringArray",arrayList);
        ArrayList<CharSequence> charList = new ArrayList<>();
        charList.add("char123");
        charList.add("广东");
        intent.putCharSequenceArrayListExtra("myCharArray",charList);


        User user = new User();
        user.setId("1001");
        user.setName("zhang");
        Bundle bundle = new Bundle();
        bundle.putSerializable("myuser",user);

        //intent.putExtras(bundle);
        intent.putExtra("myuser",user);
        MyMap myMap = new MyMap();

        Map<String,String> map = new HashMap<>();
        map.put("mk1","m123");
        map.put("mk2","mabc");
        myMap.setMap(map);
        intent.putExtra("mymap",myMap);

        User2 user2 = new User2("1003","zhongliang");
        intent.putExtra("user2",user2);
        bundle.putParcelable("u",user2);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void showDate(View view){
        new DatePickerDialog(ActivityActionBar.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
               et.setText(i+"年"+(i1+1)+"月"+i2+"日");
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
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
