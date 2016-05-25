package com.example.administrator.kaolafm50.discover.anchor_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.anchor_page.bean.Anchor;

/**
 * Created by Administrator on 16-5-20.
 */
public class AnchorAnchorLayout1 extends LinearLayout {

    private AnchorAnchorItem1 aai1,aai2,aai3;
    private TextView tvName,tvMore;
    public AnchorAnchorLayout1(Context context, Anchor anchor) {
        super(context);
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_anchor_anchor_layout1,this);
        setOrientation(VERTICAL);
        aai1= (AnchorAnchorItem1) findViewById(R.id.anchor_anchor_layout_aai1);
        aai2= (AnchorAnchorItem1) findViewById(R.id.anchor_anchor_layout_aai2);
        aai3= (AnchorAnchorItem1) findViewById(R.id.anchor_anchor_layout_aai3);
        tvName= (TextView) findViewById(R.id.anchor_anchor_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.anchor_anchor_panel_more_tv);
        setAnchor(anchor);
    }


    public AnchorAnchorLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_anchor_anchor_layout1,this);
        setOrientation(VERTICAL);
        aai1= (AnchorAnchorItem1) findViewById(R.id.anchor_anchor_layout_aai1);
        aai2= (AnchorAnchorItem1) findViewById(R.id.anchor_anchor_layout_aai2);
        aai3= (AnchorAnchorItem1) findViewById(R.id.anchor_anchor_layout_aai3);
        tvName= (TextView) findViewById(R.id.anchor_anchor_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.anchor_anchor_panel_more_tv);
    }
    private void setAnchor(Anchor anchor) {
        aai1.setSpecial1(anchor.getDataList().get(0));
        if (anchor.getDataList().size()>1) {
            aai2.setSpecial1(anchor.getDataList().get(1));
        }
        if (anchor.getDataList().size()>2) {
        aai3.setSpecial1(anchor.getDataList().get(2));
        }
        tvName.setText(anchor.getName());
        tvMore.setText("更多");
    }

}
