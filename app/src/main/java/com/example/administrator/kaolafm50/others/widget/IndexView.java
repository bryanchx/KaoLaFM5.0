package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 16-5-18.
 */
public class IndexView extends View {

    //当前的索引
    private int currentIndex=0;
    private int radius=10;
    private int count=4;
    private int color1= Color.GRAY;
    private int color2= Color.WHITE;
    private int padding=30;
    private int fromX=10;
    private int fromY=10;
    private boolean stroke;
    private Paint paint1=new Paint();
    private Paint paint2=new Paint();
    public IndexView(Context context) {
        super(context);
    }

    public IndexView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.index_styleable);
//        radius= (int) typedArray.getDimension(R.styleable.index_styleable_circle_radius,10);
//        padding= (int) typedArray.getDimension(R.styleable.index_styleable_circle_padding,30);
//        color1= (int) typedArray.getDimension(R.styleable.index_styleable_color_default,Color.GRAY);
//        color2= (int) typedArray.getDimension(R.styleable.index_styleable_color_selected,Color.WHITE);
//        stroke=(boolean) typedArray.getDimension(R.styleable.index_styleable_default_stroke,true);

        //分别设置画笔的颜色
        paint1.setColor(color1);
        paint1.setAntiAlias(true);
        paint1.setDither(true);
        paint2.setColor(color2);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int contentWidth=padding*(count-1)+2*radius;
        if (contentWidth>width) {
            throw new IllegalArgumentException("宽度不够！");
        }
        fromX=(width-(padding*(count-1)+2*radius))/2+radius;
        fromY=height/2;
        for (int i=0;i<count;i++) {
            if (i ==currentIndex) {
                canvas.drawCircle(fromX+padding*i,fromY,radius,paint2);
            } else {
                canvas.drawCircle(fromX+padding*i,fromY,radius,paint1);
            }
        }
    }
    public void changeIndex(int index){
        currentIndex=index;
        invalidate();
    }
}
