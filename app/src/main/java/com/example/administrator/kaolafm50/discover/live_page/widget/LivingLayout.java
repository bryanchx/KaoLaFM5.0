package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.administrator.kaolafm50.R;

/**
 * Created by Administrator on 16-5-22.
 */
public class LivingLayout extends LinearLayout{

    private LivingItem living_item1;
    private LivingItem living_item2;
    private LivingItem living_item3;
    private LivingItem living_item4;
    private LivingItem living_item5;

    public LivingLayout(Context context) {
        super(context);
        inflate(context, R.layout.widget_living_layout,this);
        living_item1 = (LivingItem) findViewById(R.id.living_item1);
        living_item2 = (LivingItem) findViewById(R.id.living_item2);
        living_item3 = (LivingItem) findViewById(R.id.living_item3);
        living_item4 = (LivingItem) findViewById(R.id.living_item4);
        living_item5 = (LivingItem) findViewById(R.id.living_item5);

        findViewById(R.id.living_panel_title_tv);
    }

    public LivingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_living_layout,this);

    }
}
