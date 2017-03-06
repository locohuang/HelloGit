package com.example.my.hellogit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private CheckBox cb_test;
    private ToggleButton tb_test;
    private Switch switch_test;
    private RadioGroup rg_test;
    private RadioButton rb_1,rb_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("hahahaha");
        setContentView(R.layout.activity_main);
        cb_test = (CheckBox)findViewById(R.id.cb_test);
        tb_test = (ToggleButton)findViewById(R.id.tb_test) ;
        tb_test.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this,"关",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"开",Toast.LENGTH_LONG).show();
                }
            }
        });
        cb_test.setOnCheckedChangeListener(this);
        switch_test  = (Switch)findViewById(R.id.switch_test);
        switch_test.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this,"开",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"关",Toast.LENGTH_LONG).show();
                }
            }
        });
        rg_test = (RadioGroup) findViewById(R.id.rg_test);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);

        rg_test.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton)findViewById(i);
                Toast.makeText(MainActivity.this,""+radioButton.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            cb_test.setText("checked");
        }else{
            cb_test.setText("unchecked");
        }
    }
}
