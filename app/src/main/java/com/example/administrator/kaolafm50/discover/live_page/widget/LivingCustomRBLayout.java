package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.LogUtil;

/**
 * Created by ASUS on 2016/5/22.
 */
public class LivingCustomRBLayout extends LinearLayout implements View.OnClickListener{

    private LivingCustomRBItem live_custom_lcrb1;
    private LivingCustomRBItem live_custom_lcrb2;
    private LivingCustomRBItem live_custom_lcrb3;

    public LivingCustomRBLayout(Context context) {
        super(context);
        inflate(context, R.layout.widget_live_forecast_layout, this);
        live_custom_lcrb1 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb1);
        live_custom_lcrb2 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb2);
        live_custom_lcrb3 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb3);
        live_custom_lcrb1.setOnClickListener(this);
        live_custom_lcrb2.setOnClickListener(this);
        live_custom_lcrb3.setOnClickListener(this);
        live_custom_lcrb1.setId(R.id.live_custom_lcrb1);
        live_custom_lcrb1.setId(R.id.live_custom_lcrb2);
        live_custom_lcrb1.setId(R.id.live_custom_lcrb3);
        setCustomLayout();
    }

    private void setCustomLayout() {
        live_custom_lcrb1 = new LivingCustomRBItem(getContext());
        live_custom_lcrb2 = new LivingCustomRBItem(getContext());
        live_custom_lcrb3 = new LivingCustomRBItem(getContext());

    }

    public LivingCustomRBLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_live_forecast_layout, this);
        live_custom_lcrb1 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb1);
        live_custom_lcrb2 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb2);
        live_custom_lcrb3 = (LivingCustomRBItem) findViewById(R.id.live_custom_lcrb3);
        live_custom_lcrb1.setOnClickListener(this);
        live_custom_lcrb2.setOnClickListener(this);
        live_custom_lcrb3.setOnClickListener(this);
        setCustomLayout();
    }

    //设置每个item的点击事件
    @Override
    public void onClick(View v) {
        LogUtil.w("id="+v.getId());
        live_custom_lcrb1.setSelected(true);
//        v.setSelected(true);
//        onMyItemClickListener.onMyClick(v,live_custom_lcrb1.getId());
    }

    //判断点击事件中的item的select事件
    public void isItemSelected(int i) {
                live_custom_lcrb1.setSelected(i==1);
                live_custom_lcrb1.setSelected(i==R.id.live_custom_lcrb2);
                live_custom_lcrb1.setSelected(i==R.id.live_custom_lcrb3);
    }

    //写一个接口传递点击的view
    public interface OnMyItemClickListener{
        void onMyClick(View view,int firstItemId);
    }

    private OnMyItemClickListener onMyItemClickListener;
    //写一个get方法调用此接口
    public void setonMyItemClickListener(OnMyItemClickListener onMyItemClickListener){
        this.onMyItemClickListener=onMyItemClickListener;
    }

    public View getFirstView(){
        return live_custom_lcrb1;
    }
}
