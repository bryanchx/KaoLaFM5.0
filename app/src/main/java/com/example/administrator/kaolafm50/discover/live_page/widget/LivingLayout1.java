package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.bean.SpecialInLive;

import java.util.List;

/**
 * Created by Administrator on 16-5-20.
 */
public class LivingLayout1 extends LinearLayout{
    private LivingItem1 li1, li2, li3;

    public LivingLayout1(Context context, List<SpecialInLive> list){
        super(context);
        setPadding(30,30,30,30);
        inflate(context, R.layout.widget_living_layout1, this);
        li1 = (LivingItem1) findViewById(R.id.special_layout_li1);
        li2 = (LivingItem1) findViewById(R.id.special_layout_li2);
        li3 = (LivingItem1) findViewById(R.id.special_layout_li3);

        setLivingLayout1(list);
    }

    public LivingLayout1(Context context, AttributeSet attrs){
        super(context, attrs);
        inflate(context, R.layout.widget_living_layout1, this);
        li1 = (LivingItem1) findViewById(R.id.special_layout_li1);
        li2 = (LivingItem1) findViewById(R.id.special_layout_li2);
        li3 = (LivingItem1) findViewById(R.id.special_layout_li3);

    }

    /**
     * 分别显示三个item的内容
     *
     * @param list
     */
    public void setLivingLayout1(List<SpecialInLive> list){
        li1.setLivingItem1(list.get(0));
        li2.setLivingItem1(list.get(1));
        li3.setLivingItem1(list.get(2));
        if (list.size()>3) {

        }
    }
}
