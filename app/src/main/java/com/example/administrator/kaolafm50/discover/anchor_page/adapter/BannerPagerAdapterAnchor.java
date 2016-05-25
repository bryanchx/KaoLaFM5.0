package com.example.administrator.kaolafm50.discover.anchor_page.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.kaolafm50.discover.anchor_page.bean.SpecialInAnchor;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 16-5-21.
 */
public class BannerPagerAdapterAnchor extends PagerAdapter{

    private List<SpecialInAnchor> list;
    private List<ImageView> imageViews;
    public BannerPagerAdapterAnchor(List<SpecialInAnchor> list, List<ImageView> imageViews) {
        this.list=list;
        this.imageViews=imageViews;
    }

    @Override
    public int getCount() {
        return imageViews==null?0:imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=imageViews.get(position);
        ImageLoader.getInstance().displayImage(list.get(position).getPic(),imageViews.get(position),
                ImageUtil.getNormalImageOption());
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView imageView =imageViews.get(position);
        container.removeView(imageView);
    }
}
