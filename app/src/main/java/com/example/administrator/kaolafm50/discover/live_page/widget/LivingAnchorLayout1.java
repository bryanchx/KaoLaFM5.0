package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.bean.Live;

/**
 * Created by Administrator on 16-5-20.
 */
public class LivingAnchorLayout1 extends LinearLayout {

    private LivingAnchorItem1 lai1,lai2,lai3;
    private TextView tvName,tvMore;
    public LivingAnchorLayout1(Context context, Live live) {
        super(context);
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_live_anchor_layout1,this);
        setOrientation(VERTICAL);
        lai1= (LivingAnchorItem1) findViewById(R.id.anchor_layout_lai1);
        lai2= (LivingAnchorItem1) findViewById(R.id.anchor_layout_lai2);
        lai3= (LivingAnchorItem1) findViewById(R.id.anchor_layout_lai3);
        tvName= (TextView) findViewById(R.id.anchor_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.anchor_panel_more_tv);
        setLive(live);
    }


    public LivingAnchorLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_live_anchor_layout1,this);
        setOrientation(VERTICAL);
        lai1= (LivingAnchorItem1) findViewById(R.id.anchor_layout_lai1);
        lai2= (LivingAnchorItem1) findViewById(R.id.anchor_layout_lai2);
        lai3= (LivingAnchorItem1) findViewById(R.id.anchor_layout_lai3);
        tvName= (TextView) findViewById(R.id.anchor_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.anchor_panel_more_tv);
    }
    private void setLive(Live live) {
        lai1.setSpecial1(live.getDataList().get(0));
        lai2.setSpecial1(live.getDataList().get(1));
        lai3.setSpecial1(live.getDataList().get(2));
        tvName.setText(live.getName());
        tvMore.setText("更多");
    }

}
