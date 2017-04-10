package com.example.my.hellogit;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityListView2 extends ListActivity {
    private TextView selection;
    private static final String[]items={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        selection = (TextView)findViewById(R.id.selection);
        getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,items));
    }
    /*@Override
    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(items[position]);
    }*/

    @Override
    public void onListItemClick(ListView parent,View view,int position,long id){
        selection.setText(items[position]);
    }


}
