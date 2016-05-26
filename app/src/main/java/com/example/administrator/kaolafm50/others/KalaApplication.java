package com.example.administrator.kaolafm50.others;

import android.app.Application;
import android.graphics.Bitmap;

import com.example.administrator.kaolafm50.others.utils.FileUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 16-5-19.
 */
public class KalaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);

        //配置
        Picasso picasso=new Picasso.Builder(this)
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .memoryCache(new LruCache(20<<20))//内存缓冲 20MB
                .downloader(new OkHttpDownloader(FileUtil.DIR_CACHE))
                .build();
        //设置成单例模式
        Picasso.setSingletonInstance(picasso);
    }
}
