package com.example.administrator.kaolafm50.others.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * Created by Administrator on 16-5-26.
 */
public class CircleTransform implements Transformation{

    private boolean needStroke;

    public CircleTransform(boolean needStroke) {
        this.needStroke = needStroke;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        int width = source.getWidth();
        int height = source.getHeight();
        //获取边长小的值作为裁剪后的正方形图片的边长
        int size = Math.min(width, height);
        int radius=size/2;
        int x=(width- size)/2;
        int y=(height-size)/2;
        //从原图上裁剪指定大小的正方形
        Bitmap transformBitmap = Bitmap.createBitmap(source, x, y, size, size);
        //创建一张空图片作为画布的背景
        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        //从裁剪完后的图片去除内容
        BitmapShader shader = new BitmapShader(transformBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        //把内容画成一个圆形
        canvas.drawCircle(radius,radius,radius,paint);

        if (needStroke) {
            //给图片加一个圆形边框
            Paint sPaint = new Paint();
            sPaint.setAntiAlias(true);
            sPaint.setStyle(Paint.Style.STROKE);
            sPaint.setStrokeWidth(10);
            sPaint.setColor(Color.RED);
            canvas.drawCircle(radius,radius,radius-5,sPaint);
        }
        //释放资源
        source.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return null;
    }
}
