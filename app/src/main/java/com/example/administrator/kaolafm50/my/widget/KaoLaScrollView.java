package com.example.administrator.kaolafm50.my.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Administrator on 16-5-25.
 */
public class KaoLaScrollView extends ScrollView{
    private OnMyScrollListener onMyScrollListener;

    public KaoLaScrollView(Context context) {
        super(context);
    }

    public KaoLaScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (onMyScrollListener!=null) {
            onMyScrollListener.getScrollLength();
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    public interface OnMyScrollListener{
        void getScrollLength();
    }
    public void setOnMyScrollListener(OnMyScrollListener onMyScrollListener){
        this.onMyScrollListener=onMyScrollListener;
    }
}
