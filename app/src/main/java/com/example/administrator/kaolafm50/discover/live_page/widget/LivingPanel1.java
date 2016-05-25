package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.bean.Live;

/**
 * Created by ASUS on 2016/5/22.
 */
public class LivingPanel1 extends RelativeLayout{

    private TextView living_panel_title_tv;
    private TextView living_panel_more_tv;
    private Live live;

    public LivingPanel1(Context context, Live live) {
        super(context);
        this.live=live;
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_living_panel,this);
        living_panel_title_tv = (TextView) findViewById(R.id.living_panel_title_tv);
        living_panel_more_tv = (TextView) findViewById(R.id.living_panel_more_tv);
        setLivingPanel(live);
    }

    public LivingPanel1(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_living_panel,this);
        living_panel_title_tv = (TextView) findViewById(R.id.living_panel_title_tv);
        living_panel_more_tv = (TextView) findViewById(R.id.living_panel_more_tv);
    }

    private void setLivingPanel(Live live) {
        living_panel_title_tv.setText(live.getName());

    }


}
