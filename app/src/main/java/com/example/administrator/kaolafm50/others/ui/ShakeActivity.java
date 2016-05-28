package com.example.administrator.kaolafm50.others.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.KaoLaSensorListener;
import com.example.administrator.kaolafm50.others.utils.LogUtil;

public class ShakeActivity extends AppCompatActivity {

    private KaoLaSensorListener kaoLaSensorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);

        kaoLaSensorListener = new KaoLaSensorListener(this);

        kaoLaSensorListener.setIShakeListener(new KaoLaSensorListener.IShakeListener() {

            @Override
            public void onShake(float speed) {
                LogUtil.w("摇一摇的速度="+speed);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        kaoLaSensorListener.unRegister();
    }
}
