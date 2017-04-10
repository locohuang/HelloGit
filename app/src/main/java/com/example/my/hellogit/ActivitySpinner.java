package com.example.my.hellogit;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivitySpinner extends Activity
        implements AdapterView.OnItemSelectedListener,TextWatcher{
    private Spinner spinner;
    private TextView textView;
    private AutoCompleteTextView auto;
    private static final String[]items={"vitae", "arcu", "arcquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "arcue", "arus"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = (Spinner)findViewById(R.id.spinner);
        textView = (TextView)findViewById(R.id.tv);
        auto = (AutoCompleteTextView)findViewById(R.id.auto);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);//不可以使用OnItemClick
        auto.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items));
        auto.addTextChangedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        textView.setText(items[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        textView.setText("您什么都没有选择！");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        textView.setText(auto.getText());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
