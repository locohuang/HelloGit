package com.example.my.hellogit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ActivityDemo extends Activity {
    private TextView tv_result;
    private EditText et_name,et_id;
    private RadioButton rbtn_male,rbtn_female;
    private StringBuilder stringBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        tv_result = (TextView)findViewById(R.id.tv_result);
        et_name = (EditText)findViewById(R.id.et_name);
        et_id = (EditText)findViewById(R.id.et_id);
        rbtn_male = (RadioButton)findViewById(R.id.rbtn_male);
        rbtn_female = (RadioButton)findViewById(R.id.rbtn_female);
    }
    public void display(View view){
        stringBuilder = new StringBuilder();
        stringBuilder.append("姓名："+et_name.getText().toString()+"\n");
        stringBuilder.append("身份证："+et_id.getText().toString()+"\n");
        if(rbtn_male.isChecked()){
            stringBuilder.append("性别："+rbtn_male.getText().toString()+"\n");
        }
        if(rbtn_female.isChecked()){
            stringBuilder.append("性别："+rbtn_female.getText().toString()+"\n");
        }
        tv_result.setText(stringBuilder.toString());
    }
}
