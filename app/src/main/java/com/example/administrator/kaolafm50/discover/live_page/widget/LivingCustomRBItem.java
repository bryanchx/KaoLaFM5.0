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
public class LivingCustomRBItem extends LinearLayout{

    private TextView widget_live_item_date_tv;
    private TextView widget_live_item_time_tv;
    private OnMyCheckedChangeListener onMyCheckedChangeListener;

    public LivingCustomRBItem(Context context) {
        super(context);
        inflate(context, R.layout.widget_live_forecast_item,this);
        widget_live_item_date_tv = (TextView) findViewById(R.id.widget_live_item_date_tv);
        widget_live_item_time_tv = (TextView) findViewById(R.id.widget_live_item_time_tv);
        widget_live_item_date_tv.setTextColor(Color.RED);
//        onMyCheckedChangeListener.changeColor();
        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                widget_live_item_date_tv.setTextColor(Color.RED);
                LogUtil.w("字体变红");
            }
        });
    }

    public LivingCustomRBItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_live_forecast_item,this);
        widget_live_item_date_tv = (TextView) findViewById(R.id.widget_live_item_date_tv);
        widget_live_item_time_tv = (TextView) findViewById(R.id.widget_live_item_time_tv);
    }


    public interface OnMyCheckedChangeListener{
        void changeColor();
    }

    public void setOnMyCheckedChangeListener(OnMyCheckedChangeListener onMyCheckedChangeListener){
        this.onMyCheckedChangeListener=onMyCheckedChangeListener;
    }

    public void setItemListener(View.OnClickListener listenler){
        this.setOnClickListener(listenler);
    }
}
