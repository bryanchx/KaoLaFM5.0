package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Recommend;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;

import java.util.List;

/**
 * 推荐页面的专题面板，
 * 包含一个标题、更多、一条横线、一个或者两个SpecialLayout
 */
public class SpecialPanel extends LinearLayout{

    private TextView tvTitle,tvMore;
    public SpecialPanel(Context context,Recommend recommend) {
        super(context);
        setPadding(30,30,30,30);
        setOrientation(VERTICAL);
        inflate(context, R.layout.widget_special_panel,this);
        tvTitle= (TextView) findViewById(R.id.special_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.special_panel_more_tv);
        setRecommend(recommend);
    }

    public SpecialPanel(Context context, AttributeSet attrs) {
        super(context, attrs);

        setPadding(30,30,30,30);
        setOrientation(VERTICAL);
        inflate(context, R.layout.widget_special_panel,this);
        tvTitle= (TextView) findViewById(R.id.special_panel_title_tv);
        tvMore= (TextView) findViewById(R.id.special_panel_more_tv);

    }

    public void setRecommend(Recommend recommend){
        tvTitle.setText(recommend.getName());

        List<Special> dataList = recommend.getDataList();
        if (dataList.size() > 3) {
            List<Special> specials1 = dataList.subList(0, 3);
            List<Special> specials2 = dataList.subList(3, 6);
            SpecialLayout specialLayout1 = new SpecialLayout(getContext(), specials1);
            SpecialLayout specialLayout2 = new SpecialLayout(getContext(), specials2);
            addView(specialLayout1);
            addView(specialLayout2);
        } else {
            SpecialLayout specialLayout = new SpecialLayout(getContext(), dataList);
            addView(specialLayout);
        }
    }

    /**
     * 点击更多的事件
     * @param listener
     */
    public void setOnclickMoreListener(OnClickListener listener){
        tvMore.setOnClickListener(listener);
    }

}
