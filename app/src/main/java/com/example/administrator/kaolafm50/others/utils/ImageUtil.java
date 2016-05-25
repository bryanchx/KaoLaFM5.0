package com.example.administrator.kaolafm50.others.utils;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by Administrator on 16-5-19.
 */
public class ImageUtil {
    public static DisplayImageOptions getNormalImageOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                 .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
                return options;
    }
    /**
     * 获取一个圆形图形
     */
    public static DisplayImageOptions getCircleImageOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new CircleBitmapDisplayer())
                .build();
        return options;
    }
    /**
     * 获取一个圆角图形
     */
    public static DisplayImageOptions getRoundImageOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new RoundedBitmapDisplayer(10))
                .build();
        return options;
    }

}
