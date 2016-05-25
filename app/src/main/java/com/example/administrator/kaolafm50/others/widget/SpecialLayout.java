package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;

import java.util.List;

/**
 * Created by Administrator on 16-5-20.
 */
public class SpecialLayout extends LinearLayout{
    private SpecialItem si1, si2, si3;

    public SpecialLayout(Context context, List<Special> list)
    {
        super(context);
        inflate(context, R.layout.widget_special_layout, this);
        si1 = (SpecialItem) findViewById(R.id.special_layout_si1);
        si2 = (SpecialItem) findViewById(R.id.special_layout_si2);
        si3 = (SpecialItem) findViewById(R.id.special_layout_si3);

        setSpecialList(list);
    }

    public SpecialLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        inflate(context, R.layout.widget_special_layout, this);
        si1 = (SpecialItem) findViewById(R.id.special_layout_si1);
        si2 = (SpecialItem) findViewById(R.id.special_layout_si2);
        si3 = (SpecialItem) findViewById(R.id.special_layout_si3);
    }

    /**
     * 分别显示三个item的内容
     *
     * @param list
     */
    public void setSpecialList(List<Special> list)
    {
        si1.setSpecial(list.get(0));
        si2.setSpecial(list.get(1));
        si3.setSpecial(list.get(2));
    }
}
