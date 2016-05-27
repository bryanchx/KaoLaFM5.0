package com.example.administrator.kaolafm50.discover.recommend_page.ui;


import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.adapter.BannerPagerAdapter;
import com.example.administrator.kaolafm50.discover.recommend_page.adapter.EnterAdapter;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Recommend;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.example.administrator.kaolafm50.discover.util.DiscoverHttpUtil;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.example.administrator.kaolafm50.others.utils.KalaTask;
import com.example.administrator.kaolafm50.others.widget.ActiveLayout;
import com.example.administrator.kaolafm50.others.widget.AnchorLayout;
import com.example.administrator.kaolafm50.others.widget.SpecialPanel;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment {

    private ViewPager recommend_banner_vp;
    private BannerPagerAdapter bannerPagerAdapter;
    private TabLayout recommend_tl;
    private RecyclerView recommend_rv;
    private EnterAdapter enterAdapter;
    private List<Special> enterList=new ArrayList<>();
    private LinearLayout recommend_ll;
    private SpecialPanel panel;
    private Handler mHandler;
    private int i=0;

    private PullToRefreshScrollView pullToRefreshScrollView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        pullToRefreshScrollView= (PullToRefreshScrollView) root;
        recommend_banner_vp= (ViewPager) root.findViewById(R.id.recommend_banner_vp);
        recommend_tl = (TabLayout) root.findViewById(R.id.recommend_tl);
        recommend_rv = (RecyclerView) root.findViewById(R.id.recommend_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recommend_rv.setLayoutManager(linearLayoutManager);

        recommend_ll = (LinearLayout) root.findViewById(R.id.recommend_ll);
    }

    @Override
    protected void initEvent() {
//        pullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
//
//            @Override
//            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
//                requestData();
//            }
//        });
        pullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                requestData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                requestData();
            }
        });
    }

    @Override
    protected void initData() {
        enterAdapter=new EnterAdapter(getActivity(),enterList);
        recommend_rv.setAdapter(enterAdapter);

        //请求网络，下载数据
        requestData();

    }

    /**
     * 请求网络，下载数据
     */
    private void requestData() {
        DiscoverHttpUtil.getRecommend(new KalaTask.IRequestCallback() {

            @Override
            public void success(Object obj) {
                try {
                    JSONObject root = new JSONObject(obj.toString());
                    String message = root.getString("message");
                    if ("success".equals(message)) {
                        JSONObject result = root.getJSONObject("result");
                        JSONArray dataList = result.getJSONArray("dataList");

                        List<Recommend> list=Recommend.arrayRecommendFromData(dataList.toString());

                        //防止下拉刷新数据重复的方案，全部动态添加
                        //在刷新请求成功后，先清除所有，然后添加
                        //显示广告
                        showBanner(list.get(0));
                        showEnter(list.get(1));

                        for (int i=0;i<list.size();i++) {
                            Recommend recommend = list.get(i);
                            int componentType = recommend.getComponentType();
                            switch (componentType) {
                                case Recommend.ContentType.TYPE_PANEL:
                                    addSpecialPanel(recommend);
                                    break;
                                case Recommend.ContentType.TYPE_IMAGE:
                                    addImageView(recommend);
                                    break;
                                case Recommend.ContentType.TYPE_ACTIVE:
                                    addActive(recommend);
                                    break;
                                case Recommend.ContentType.TYPE_ANCHOR:
                                    addAnchorLayout(recommend);
                                    break;
                            }
                        }
                        //在数据请求成功并解析完成后结束刷新
                        pullToRefreshScrollView.onRefreshComplete();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void error(String msg) {
                //在数据请求后也结束刷新
                pullToRefreshScrollView.onRefreshComplete();
                Toast.makeText(getActivity(),"亲，请求网络失败，继续刷新试试？",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showEnter(Recommend recommend) {
        List<Special> dataList=recommend.getDataList();
        enterList.addAll(dataList);
        enterAdapter.notifyDataSetChanged();
    }

    private void showBanner(Recommend recommend) {
        List<Special> dataList=recommend.getDataList();
        List<ImageView> views=new ArrayList<>();
        for (int i=0;i<dataList.size();i++) {
            ImageView imageView=new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            views.add(imageView);
            recommend_tl.addTab(recommend_tl.newTab());
        }
        bannerPagerAdapter=new BannerPagerAdapter(views,dataList);
        recommend_banner_vp.setAdapter(bannerPagerAdapter);
        //把广告和tabLayout关联起来
        recommend_tl.setupWithViewPager(recommend_banner_vp);
        //viewpage滚动
        scrollViewPager();
    }

//    private void showMustListen(Recommend recommend) {
//        panel = new SpecialPanel(getActivity(), recommend);
//        recommend_ll.addView(panel);
//        List<Special> dataList = recommend.getDataList();
//        if (dataList.size() > 3) {
//            List<Special> specials1 = dataList.subList(0, 3);
//            List<Special> specials2 = dataList.subList(3, 6);
//            SpecialLayout specialLayout1 = new SpecialLayout(getActivity(), specials1);
//            SpecialLayout specialLayout2 = new SpecialLayout(getActivity(), specials2);
//            recommend_ll.addView(specialLayout1);
//            recommend_ll.addView(specialLayout2);
//        } else {
//            SpecialLayout specialLayout = new SpecialLayout(getActivity(), dataList);
//            recommend_ll.addView(specialLayout);
//        }
//    }

//    private void showTalkshow(Recommend recommend) {
//        panel = new SpecialPanel(getActivity(), recommend);
//        recommend_ll.addView(panel);
//    }
//    private void showTalkshow1(Recommend recommend) {
//        SpecialLayout specialLayout = new SpecialLayout(getActivity(), recommend.getDataList());
//        recommend_ll.addView(specialLayout);
//
//    }

    private void addSpecialPanel(Recommend recommend){
        SpecialPanel specialPanel = new SpecialPanel(getActivity(), recommend);
        recommend_ll.addView(specialPanel);
    }

    public void addImageView(Recommend recommend){
        ImageView imageView = new ImageView(getActivity());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 300);
        layoutParams.setMargins(30,15,30,15);
        imageView.setLayoutParams(layoutParams);
        ImageLoader.getInstance().displayImage(recommend.getDataList().get(0).getPic(),
                imageView, ImageUtil.getNormalImageOption());
        recommend_ll.addView(imageView);
    }

    private void addActive(Recommend recommend) {
        ActiveLayout activeLayout = new ActiveLayout(getActivity(), recommend);

        recommend_ll.addView(activeLayout);
    }

    private void addAnchorLayout(Recommend recommend) {
        AnchorLayout anchorLayout = new AnchorLayout(getActivity(), recommend);

        recommend_ll.addView(anchorLayout);
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
                recommend_banner_vp.setCurrentItem(i%5,true);
            }
        };
    }
}
