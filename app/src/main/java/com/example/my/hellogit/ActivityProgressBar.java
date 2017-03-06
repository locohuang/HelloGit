package com.example.my.hellogit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class ActivityProgressBar extends Activity {
    private ProgressBar progressBar;
    private Handler handler;
    private Random random;
    private int totalValue;
    private boolean isStop ;
    private Button btn_start;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        tv = (TextView)findViewById(R.id.tv);
        random=new Random();
        totalValue=0;
        isStop = false;
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0x110){
                    progressBar.setProgress(totalValue);
                    if(totalValue>=100) {
                        isStop =true;
                    }
                }

            }
        };
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //tv.setText("helohelo");
                        progressBar.setProgress(totalValue);
                        while(!isStop) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            int ranValue = random.nextInt(10);
                            totalValue += ranValue;
                            progressBar.setProgress(totalValue);
                            //handler.sendEmptyMessage(0x110);
                        }
                    }
                }).start();
            }
        });

    }
}
