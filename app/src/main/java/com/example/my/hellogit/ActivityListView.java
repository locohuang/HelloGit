package com.example.my.hellogit;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityListView extends Activity {
    private ListView listView;
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
        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listView);
        selection = (TextView)findViewById(R.id.selection);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(((TextView)view).getText());
                //selection.setText(items[i]);
                //selection.setText(((TextView)listView.getChildAt(i)).getText());
                //selection.setText(""+i+"   "+l);
                //selection.setText(((TextView)adapterView.getChildAt(i)).getText());

            }
        });
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                    Toast.makeText(ActivityListView.this,view.getId()+" down ",Toast.LENGTH_SHORT).show();
                if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                    Toast.makeText(ActivityListView.this,view.getId()+" up ",Toast.LENGTH_SHORT).show();

                return false;//return true;
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityListView.this,items[i],Toast.LENGTH_SHORT).show();

                return true;
            }
        });
        //此方法用于类似TV远程控制器选择操作
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(items[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
