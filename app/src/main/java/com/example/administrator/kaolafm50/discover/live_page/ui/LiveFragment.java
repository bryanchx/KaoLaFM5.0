package com.example.administrator.kaolafm50.discover.live_page.ui;


import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.adapter.BannerPagerAdapterLive;
import com.example.administrator.kaolafm50.discover.live_page.bean.Live;
import com.example.administrator.kaolafm50.discover.live_page.bean.SpecialInLive;
import com.example.administrator.kaolafm50.discover.live_page.widget.LivingAnchorLayout1;
import com.example.administrator.kaolafm50.discover.live_page.widget.LivingCustomRBLayout;
import com.example.administrator.kaolafm50.discover.live_page.widget.LivingItem;
import com.example.administrator.kaolafm50.discover.live_page.widget.LivingLayout1;
import com.example.administrator.kaolafm50.discover.live_page.widget.LivingPanel;
import com.example.administrator.kaolafm50.discover.live_page.widget.LivingPanel1;
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
public class LiveFragment extends BaseFragment {


    private ViewPager live_vp_banner;
    private TabLayout live_tl_banner;
    private LinearLayout live_ll;
    private int i=0;
    private Handler mHandler;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initView() {
        live_vp_banner = (ViewPager) root.findViewById(R.id.live_vp_banner);
        live_tl_banner = (TabLayout) root.findViewById(R.id.live_tl_banner);
        live_ll = (LinearLayout) root.findViewById(R.id.live_ll);
    }

    @Override
    protected void initEvent() {


    }

    @Override
    protected void initData() {
        DiscoverHttpUtil.getLive(new KalaTask.IRequestCallback() {

            @Override
            public void success(Object obj) {
                try {
                    JSONObject root=new JSONObject(obj.toString());
                    String message = root.getString("message");
                    if (message.equals("success")) {
                        JSONObject result = root.getJSONObject("result");
                        JSONArray dataList = result.getJSONArray("dataList");
                        List<Live> list = Live.arrayLiveFromData(dataList.toString());
                        for (int i=0;i<list.size();i++) {
                            Live live=list.get(i);
                            int componentType = live.getComponentType();
                            switch (componentType) {
                                case Live.ContentType.TYPE_BANNER:
                                    //加载广告
                                    showBanner(live);
                                    break;
                                case Live.ContentType.TYPE_ISLIVING:
                                    //加载布局表头
                                    showPanel(live);
                                    //加载正在直播
                                    showLiving(live);
                                    break;
                                case Live.ContentType.TYPE_IMAGE:
                                    //加载单张图片广告
                                    showImage(live);
                                    break;
                                case Live.ContentType.TYPE_ONLINEDRAGON:
                                    //加载布局表头
                                    showPanel1(live);
                                    //加载线上沙龙等
                                    showSpecial(live);
                                    break;
                                case Live.ContentType.TYPE_ANCHOR:
                                    //热门主播
                                    showAnchor(live);
                                    break;
                                case Live.ContentType.TYPE_ADVANCE_NOTICE:
                                    //加载布局表头(没有更多)
                                    showPanel2(live);
//                                    //精选直播预告
                                    showForecast(live);
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

    /**
     * 直播预告
     * @param live
     */
    private void showForecast(Live live) {
        LivingCustomRBLayout livingCustomRBLayout = new LivingCustomRBLayout(getActivity());

        live_ll.addView(livingCustomRBLayout);
    }


    private void showPanel2(Live live) {
        LivingPanel1 livingPanel1 = new LivingPanel1(getActivity(), live);
        TextView living_panel_more_tv = (TextView) livingPanel1.findViewById(R.id.living_panel_more_tv);
        living_panel_more_tv.setText(null);
        living_panel_more_tv.setCompoundDrawables(null,null,null,null);
        live_ll.addView(livingPanel1);
    }

    /**
     * 主播
     * @param live
     */
    private void showAnchor(Live live) {
        LivingAnchorLayout1 livingAnchorLayout1 = new LivingAnchorLayout1(getActivity(), live);
        live_ll.addView(livingAnchorLayout1);
    }

    private void showPanel1(Live live) {
        LivingPanel1 livingPanel1 = new LivingPanel1(getActivity(), live);
        live_ll.addView(livingPanel1);
    }

    private void showSpecial(Live live) {
        List<SpecialInLive> list = live.getDataList();
        List<SpecialInLive> list1 = list.subList(0, 3);
        LivingLayout1 livingLayout1 = new LivingLayout1(getActivity(), list1);
        live_ll.addView(livingLayout1);
        if (list.size()>3) {
            List<SpecialInLive> list2 = list.subList(3, 6);
            LivingLayout1 livingLayout2 = new LivingLayout1(getActivity(), list2);
            live_ll.addView(livingLayout2);
        }
    }

    /**
     * 单张广告图片
     * @param live
     */
    private void showImage(Live live) {
        ImageView imageView = new ImageView(getActivity());
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,240);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        layoutParams.setMargins(30,30,30,30);
        imageView.setLayoutParams(layoutParams);
        ImageLoader.getInstance().displayImage(live.getDataList().get(0).getPic(),imageView,
                ImageUtil.getNormalImageOption());
        live_ll.addView(imageView);
    }

    /**
     * 版块的表头（点击更多）
     * @param live
     */
    private void showPanel(Live live) {
        LivingPanel livingPanel = new LivingPanel(getActivity(), live);
        live_ll.addView(livingPanel);
    }

    /**
     * 正在直播版块
     * @param live
     */
    private void showLiving(Live live) {
        List<SpecialInLive> list = live.getDataList();
        for (int i=0;i<list.size();i++) {
            LivingItem livingItem = new LivingItem(getActivity(), list.get(i));
            live_ll.addView(livingItem);
        }
    }

    /**
     * viewpage广告视图
     * @param live
     */
    private void showBanner(Live live) {
        List<ImageView> imageViews=new ArrayList<>();
        List<SpecialInLive> list=live.getDataList();
        for (int i=0;i<list.size();i++) {
            ImageView imageView=new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
            live_tl_banner.addTab(live_tl_banner.newTab());
        }
        BannerPagerAdapterLive adapterLive = new BannerPagerAdapterLive(live.getDataList(), imageViews);
        live_vp_banner.setAdapter(adapterLive);
        live_tl_banner.setupWithViewPager(live_vp_banner);

        //viewpage广告水平滚动
        scrollViewPager();

    }

    /**
     * 水平滚动viewpage（广告）
     */
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
                live_vp_banner.setCurrentItem(i%5,true);
            }
        };
    }


}
