package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.LogUtil;

/**
 * Created by ASUS on 2016/5/22.
 */
public class LivingCustomRBLayout extends LinearLayout {

    private LivingCustomRBItem live_custom_lcrb1;
    private LivingCustomRBItem live_custom_lcrb2;
    private LivingCustomRBItem live_custom_lcrb3;

    public LivingCustomRBLayout(Context context) {
        super(context);
        inflate(context, R.layout.widget_live_forecast_layout,this);
        live_custom_lcrb1 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb1);
        live_custom_lcrb2 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb2);
        live_custom_lcrb3 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb3);
        live_custom_lcrb1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView date = (TextView) live_custom_lcrb1.findViewById(R.id.widget_live_item_date_tv);
                date.setTextColor(Color.RED);
                date.setText("hoangs");
                live_custom_lcrb1.setBackgroundColor(Color.RED);
                LogUtil.w("live_custom_lcrb1.setOnClickListener(new");
            }
        });
        setCustomLayout();
    }

    private void setCustomLayout() {
        live_custom_lcrb1=new LivingCustomRBItem(getContext());
        live_custom_lcrb2=new LivingCustomRBItem(getContext());
        live_custom_lcrb3=new LivingCustomRBItem(getContext());
//        live_custom_lcrb1.setItemListener(this);
//        live_custom_lcrb2.setItemListener(this);
//        live_custom_lcrb3.setItemListener(this);
    }

    public LivingCustomRBLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_live_forecast_layout,this);
        live_custom_lcrb1 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb1);
        live_custom_lcrb2 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb2);
        live_custom_lcrb3 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb3);
        setCustomLayout();
    }

}
