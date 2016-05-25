package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 16-5-25.
 */
public class KaoLaViewPager extends ViewPager{

    public KaoLaViewPager(Context context) {
        super(context);
    }

    public KaoLaViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        LogUtil.w("KaoLaViewPager+dispatchTouchEvent="+ EventUtil.parseEvent(ev));

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        LogUtil.w("KaoLaViewPager+onTouchEvent="+ EventUtil.parseEvent(ev));
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        LogUtil.w("KaoLaViewPager+onInterceptTouchEvent="+ EventUtil.parseEvent(ev));

        return super.onInterceptTouchEvent(ev);
    }
}
