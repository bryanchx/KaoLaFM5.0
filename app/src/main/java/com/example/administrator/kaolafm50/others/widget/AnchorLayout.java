package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Recommend;

/**
 * Created by Administrator on 16-5-20.
 */
public class AnchorLayout extends LinearLayout {

    private AnchorItem ai1,ai2,ai3;
    private TextView tvName,tvMore;
    public AnchorLayout(Context context, Recommend recommend) {
        super(context);
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_anchor_layout,this);
        setOrientation(VERTICAL);
        ai1= (AnchorItem) findViewById(R.id.anchor_layout_ai1);
        ai2= (AnchorItem) findViewById(R.id.anchor_layout_ai2);
        ai3= (AnchorItem) findViewById(R.id.anchor_layout_ai3);
        tvName= (TextView) findViewById(R.id.anchor_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.anchor_panel_more_tv);
        setRecommend(recommend);
    }


    public AnchorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_anchor_layout,this);
        setOrientation(VERTICAL);
        ai1= (AnchorItem) findViewById(R.id.anchor_layout_ai1);
        ai2= (AnchorItem) findViewById(R.id.anchor_layout_ai2);
        ai3= (AnchorItem) findViewById(R.id.anchor_layout_ai3);
        tvName= (TextView) findViewById(R.id.anchor_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.anchor_panel_more_tv);
    }
    private void setRecommend(Recommend recommend) {
        ai1.setSpecial(recommend.getDataList().get(0));
        ai2.setSpecial(recommend.getDataList().get(1));
        ai3.setSpecial(recommend.getDataList().get(2));
        tvName.setText(recommend.getName());
        tvMore.setText("更多");
    }

}
