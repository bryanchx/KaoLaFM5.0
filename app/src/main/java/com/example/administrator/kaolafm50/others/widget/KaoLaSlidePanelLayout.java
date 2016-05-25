package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.administrator.kaolafm50.others.utils.EventUtil;
import com.example.administrator.kaolafm50.others.utils.LogUtil;

/**
 * Created by Administrator on 16-5-25.
 */
public class KaoLaSlidePanelLayout extends SlidingPaneLayout{

    private int childPagerIndex;
    private IindexListener listener;

    public KaoLaSlidePanelLayout(Context context) {
        super(context);
    }

    public KaoLaSlidePanelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KaoLaSlidePanelLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.w("KaoLaSlidePanelLayout+dispatchTouchEvent="+ EventUtil.parseEvent(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        LogUtil.w("KaoLaSlidePanelLayout+onTouchEvent="+ EventUtil.parseEvent(ev));
        return super.onTouchEvent(ev);
    }
    //拦截事件的方法
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (listener!=null) {
            childPagerIndex=listener.getIndex();
        }
        LogUtil.w("KaoLaSlidePanelLayout+onInterceptTouchEvent="+ EventUtil.parseEvent(ev));
        if (childPagerIndex!=0) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
    public interface IindexListener{
        int getIndex();
    }
    public void setIindexListener(IindexListener listener){
        this.listener=listener;
    }
}
