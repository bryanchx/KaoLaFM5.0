package com.example.administrator.kaolafm50.others.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * Created by Administrator on 16-5-26.
 */
public class TriangleTransform implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        Bitmap bitmap=Bitmap.createBitmap(source.getWidth(),source.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(source);
        Paint paint = new Paint();

        BitmapShader shader = new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        Path path = new Path();
        path.moveTo(100,100);
        path.moveTo(100,200);
        path.moveTo(200,200);
        path.close();
        canvas.drawPath(path,paint);

        source.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return null;
    }
}
