package com.example.administrator.kaolafm50.others.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.ActivityJumpManager;
import com.example.administrator.kaolafm50.others.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isFirstUsed()) {
            ActivityJumpManager.jumpToGuide(this);
        } else {
            ActivityJumpManager.jumpToBanner(this);
        }
        finish();
    }

    public boolean isFirstUsed(){
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.FLAG_FIRST_USED, MODE_PRIVATE);
        boolean used = sharedPreferences.getBoolean(Constants.GETFLAG_FIRST_USED_TAG, true);
        return used;
    }
}
