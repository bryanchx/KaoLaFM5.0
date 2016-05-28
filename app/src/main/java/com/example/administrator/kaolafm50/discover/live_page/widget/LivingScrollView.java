package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Administrator on 16-5-28.
 */
public class LivingScrollView extends ScrollView{

    private OnLivingScrollViewListener onLivingScrollViewListener;

    public LivingScrollView(Context context) {
        super(context);
    }

    public LivingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onLivingScrollViewListener!=null) {
            onLivingScrollViewListener.onLivingScrollChanged(l, t, oldl, oldt);
        }
    }

    //定义一个接口传值
    public interface OnLivingScrollViewListener{
        void onLivingScrollChanged(int l, int t, int oldl, int oldt);
    }

    //写一个方法传递接口
    public void setOnLivingScrollViewListener(OnLivingScrollViewListener onLivingScrollViewListener){
        this.onLivingScrollViewListener=onLivingScrollViewListener;
    }
}
