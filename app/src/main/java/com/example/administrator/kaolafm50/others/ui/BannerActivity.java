package com.example.administrator.kaolafm50.others.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.ActivityJumpManager;

public class BannerActivity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(0);
            }
        }.start();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                ActivityJumpManager.jumpToHome(BannerActivity.this);
                finish();
            }
        };
    }

}
