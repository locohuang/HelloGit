package com.example.my.hellogit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityListView extends Activity {
    private ListView listView;
    private TextView selection;
    private TextView textView1;
    private Button button;
    private SparseBooleanArray sba = new SparseBooleanArray();
    private String selectedIds = "";
    private static final String[]tv1={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};
    private static final String[]tv2={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};
    private static final int[]imgIds ={R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,
            R.mipmap.img07,R.mipmap.img08,R.mipmap.img09,
            R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,
            R.mipmap.img07,R.mipmap.img08,R.mipmap.img09,
            R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,
            R.mipmap.img07};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listView);
        //listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        selection = (TextView)findViewById(R.id.selection);
        button = (Button)findViewById(R.id.btn_getAll);
        String myValue = getIntent().getStringExtra("mykey");
        double myDouble = getIntent().getDoubleExtra("myDouble",0);
        System.out.println("get:"+myValue+"   "+myDouble);
        ArrayList<String> arrayList = getIntent().getStringArrayListExtra("myStringArray");
        for(String str:arrayList){
            System.out.println("array:"+str);
        }
        ArrayList<CharSequence> charList = getIntent().getCharSequenceArrayListExtra("myCharArray");
        for(CharSequence str:charList){
            System.out.println("char:"+str);
        }
        /*final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,tv1);*/
        List<Map<String,String> > data =new ArrayList<>();
        for(int i=0;i<tv1.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("img",String.valueOf(imgIds[i]));
            map.put("tv1",tv1[i]);
            map.put("tv2",tv2[i]);
           data.add(map);
        }

        User user =(User) getIntent().getSerializableExtra("myuser");
        System.out.println(user.getId()+"  "+user.getName());

        MyMap map = (MyMap)getIntent().getSerializableExtra("mymap");
        System.out.println(map.getMap().get("mk1")+"   "+map.getMap().get("mk2"));


        User2 user2 = getIntent().getParcelableExtra("user2");
        System.out.println(user2.getId()+"  "+user2.getName());

        Bundle bundle = getIntent().getExtras();
        User2 u =(User2) bundle.getParcelable("u");
        System.out.println("u:"+u.getId()+"  "+u.getName());
        /*SimpleAdapter simpleAdapter=
                new SimpleAdapter(this,data,R.layout.item,
                        new String[]{"img","tv1","tv2"},
                        new int[]{R.id.my_img,R.id.tv11,R.id.tv2});*/
        MySimpleAdapter simpleAdapter =
                new MySimpleAdapter(this,data,R.layout.item,
                        new String[]{"img","tv1","tv2"},
                        new int[]{R.id.my_img,R.id.tv11,R.id.tv2});
        listView.setAdapter(simpleAdapter);
        //Toast.makeText(this," "+simpleAdapter.getCount(),Toast.LENGTH_SHORT).show();
        /*for(int i=0;i<simpleAdapter.getCount();i++){
            if(i%3==0) {
                View view = listView.getChildAt(i);

                TextView textView = (TextView) simpleAdapter.getView(i,view,listView).findViewById(R.id.tv11);

                textView.setText("abc");
                selection.setText(textView.getText());
                textView.setTextColor(Color.RED);

            }
        }*/
        simpleAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //selection.setText(((TextView)view).getText());
                //selection.setText(items[i]);
                //selection.setText(((TextView)listView.getChildAt(i)).getText());
                //selection.setText(""+i+"   "+l);
                //selection.setText(((TextView)adapterView.getChildAt(i)).getText());

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sba = listView.getCheckedItemPositions();
                for(int i=0;i<sba.size();i++){
                    int key = sba.keyAt(i);
                    selectedIds = selectedIds+" "+key;
                }


                selection.setText(selectedIds);
                selectedIds="";
            }
        });
        /*listView.setOnTouchListener(new View.OnTouchListener() {
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
        });*/


    }
    class ViewHolder{
        ImageView img = null;
        TextView tv11 = null;
        TextView tv2 = null;

        public ViewHolder(View row) {
            img = (ImageView)row.findViewById(R.id.my_img);
            tv11 = (TextView)row.findViewById(R.id.tv11);
            tv2 = (TextView)row.findViewById(R.id.tv2);
        }
    }
    class MySimpleAdapter extends SimpleAdapter{
        private Context mContext;
        private List<Map<String,String>> mList;
        private int mResource;
        private String[]mFrom;
        private int[] mTo;

        public MySimpleAdapter(Context context, List< Map<String, String>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.mContext = context;
            this.mList = data;
            this.mResource = resource;
            this.mFrom = from;
            this.mTo = to;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            convertView = inflater.inflate(mResource,parent,false);
            View view = super.getView(position,convertView,parent);
            ViewHolder viewHolder = (ViewHolder)view.getTag();
            if(viewHolder == null){
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            }
            /*ImageView img = (ImageView)view.findViewById(mTo[0]);
            TextView tv1 = (TextView) view.findViewById(mTo[1]);
            TextView tv2 = (TextView) view.findViewById(mTo[2]);
            img.setImageResource(Integer.parseInt(mList.get(position).get("img")));
            tv1.setText(mList.get(position).get("tv1"));
            tv2.setText(mList.get(position).get("tv2"));
            if(position%3==0){
                tv1.setBackgroundColor(Color.RED);
            }*/
            viewHolder.img.setImageResource(Integer.parseInt(mList.get(position).get("img")));
            viewHolder.tv11.setText(mList.get(position).get("tv1"));
            viewHolder.tv2.setText(mList.get(position).get("tv2"));
            if(position%5==0){
                viewHolder.tv2.setBackgroundColor(Color.GRAY);
            }else {
                viewHolder.tv2.setBackgroundColor(Color.BLUE);
            }
            return view;
            //return convertView;
        }
    }
}
