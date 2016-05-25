package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.RadioButton;

/**
 * Created by Administrator on 16-5-23.
 */
public class MyRadioButton extends RadioButton implements CompoundButton.OnCheckedChangeListener {

    public MyRadioButton(Context context) {
        super(context);
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
