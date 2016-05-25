package com.example.administrator.kaolafm50.discover.recommend_page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 16-5-23.
 */
public class VerticalScrollTextView extends View{

    /**
     * 用来存放循环滚动的数据
     */
    private List<String> list;
    /**
     * 用来切换显示
     */
    private String text1,text2;
    /**
     * 滚动一次需要的时间
     * @param context
     */
    private int duration=1000;
    /**
     * 滚动速度，即每次Y坐标的变化值
     */
    private int speed=5;
    /**
     *没滚动一次停顿的时间
     */
    private int delay;
    /**
     * 字体颜色
     */
    private int color;
    /**
     * 两个字符串的Y坐标
     */
    private int y1,y2;
    /**
     * 起始坐标
     */
    private int fromX=0,fromY=0;
    private Paint mPaint;

    public VerticalScrollTextView(Context context) {
        super(context);

    }

    public VerticalScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //控件刚显示出来的时候调用
        if (text1==null||text2==null) {
            return;
        }
        canvas.drawText(text1,fromX,y1,mPaint);
        //y2的坐标比y1打一个控件的高度
        y2=y1+getHeight();
        canvas.drawText(text2,fromX,y2,mPaint);
        prepareScroll();
    }

    private void start(){
        //在默认的Y坐标要减去一个单位
        fromY=(getHeight()-getTextHeight(text1))/2;
        y1=fromY;
        //再来更新画布
        invalidate();
        //这是一个循环操作，那么什么时候停止呢
        if (needPause()) {
            pause();
        } else {
            scroll();
        }

    }

    //或得字符串的高度
    private int getTextHeight(String text) {
        Rect rect = new Rect();
        mPaint.getTextBounds(text,0,text.length(),rect);
        int height = rect.bottom - rect.top;
        return height;
    }
    /**
     * 滚动
     */
    private void scroll() {

    }
    /**
     * 是否需要暂停
     * @return
     */
    private boolean needPause(){
        //当y2滑动到初始Y坐标（在第一次绘制的时候计算出来）或者以上时，让循环动作停止
        return y2<=fromY;
    }
    /**
     *是否暂停滚动
     */
    public void pause(){

    }

    /**
     * 切换下一个
     */
    private void changeNext(){

    }
    public void setDataList(List<String> list){
        this.list=list;

    }

    private void prepareScroll(){
        text1=list.get(0);
        text2=list.get(1);
        start();
    }
}
