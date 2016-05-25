package com.example.administrator.kaolafm50.discover.recommend_page.adapter;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 16-5-19.
 */
public class BannerPagerAdapter extends PagerAdapter{

    private List<ImageView> views;
    private List<Special> specials;
    private DisplayImageOptions options= new DisplayImageOptions.Builder()
            .bitmapConfig(Bitmap.Config.RGB_565)
            .cacheOnDisk(true)
            .cacheInMemory(true)
            .build();

    public BannerPagerAdapter(List<ImageView> views, List<Special> specials) {
        this.views = views;
        this.specials = specials;
    }

    @Override
    public int getCount() {
        return views==null?0:views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = views.get(position);

        ImageLoader.getInstance().displayImage(specials.get(position).getPic(),imageView,options);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView imageView = views.get(position);
        container.removeView(imageView);
    }
}
