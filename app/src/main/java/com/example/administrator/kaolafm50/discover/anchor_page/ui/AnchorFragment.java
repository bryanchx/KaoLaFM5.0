package com.example.administrator.kaolafm50.discover.anchor_page.ui;


import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.anchor_page.adapter.BannerPagerAdapterAnchor;
import com.example.administrator.kaolafm50.discover.anchor_page.bean.Anchor;
import com.example.administrator.kaolafm50.discover.anchor_page.bean.SpecialInAnchor;
import com.example.administrator.kaolafm50.discover.anchor_page.widget.AnchorAnchorLayout1;
import com.example.administrator.kaolafm50.discover.util.DiscoverHttpUtil;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.example.administrator.kaolafm50.others.utils.KalaTask;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnchorFragment extends BaseFragment {

    private ViewPager anchor_vp_banner;
    private TabLayout anchor_tl_banner;
    private LinearLayout anchor_ll;
    private int i=0;
    private int count=1;
    private Handler mHandler;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_anchor;
    }

    @Override
    protected void initView() {
        anchor_vp_banner = (ViewPager) root.findViewById(R.id.anchor_vp_banner);
        anchor_tl_banner = (TabLayout) root.findViewById(R.id.anchor_tl_banner);
        anchor_ll = (LinearLayout) root.findViewById(R.id.anchor_ll);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        DiscoverHttpUtil.getAnchor(new KalaTask.IRequestCallback() {

            @Override
            public void success(Object obj) {
                try {
                    JSONObject root=new JSONObject(obj.toString());
                    String message = root.getString("message");
                    if (message.equals("success")) {
                        JSONObject result = root.getJSONObject("result");
                        JSONArray dataList = result.getJSONArray("dataList");
                        List<Anchor> list = Anchor.arrayAnchorFromData(dataList.toString());
                        for (int i=0;i<list.size();i++) {
                            Anchor anchor=list.get(i);
                            int componentType = anchor.getComponentType();
                            switch (componentType) {
                                case Anchor.ContentType.TYPE_BANNER:
                                    //加载广告
                                    showBanner(anchor);
                                    break;
                                case Anchor.ContentType.TYPE_ANCHOR:
                                    //加载主播
                                    showAnchor(anchor);
                                    break;
                            }

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void error(String msg) {

            }
        });

    }

    private void showAnchor(Anchor anchor) {
        AnchorAnchorLayout1 anchorAnchorLayout1 = new AnchorAnchorLayout1(getActivity(), anchor);
        anchor_ll.addView(anchorAnchorLayout1);
    }

    private void showBanner(Anchor anchor) {
        List<SpecialInAnchor> list=anchor.getDataList();
        List<ImageView> imageViews=new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            count=list.size();
            ImageView imageView=new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageLoader.getInstance().displayImage(list.get(i).getPic(),imageView,
                    ImageUtil.getNormalImageOption());
            imageViews.add(imageView);
            anchor_tl_banner.addTab(anchor_tl_banner.newTab());
        }
        BannerPagerAdapterAnchor bannerPagerAdapterAnchor = new BannerPagerAdapterAnchor(list, imageViews);
        anchor_vp_banner.setAdapter(bannerPagerAdapterAnchor);
        anchor_tl_banner.setupWithViewPager(anchor_vp_banner);
        scrollViewPager();
    }

    private void scrollViewPager() {

        new Thread(){

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ++i;
                    mHandler.sendEmptyMessage(0);
                }
            }
        }.start();
        mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                anchor_vp_banner.setCurrentItem(i%count,true);
            }
        };
    }
}
