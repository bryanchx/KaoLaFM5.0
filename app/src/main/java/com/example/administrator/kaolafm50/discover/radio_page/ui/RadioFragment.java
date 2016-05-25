package com.example.administrator.kaolafm50.discover.radio_page.ui;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.radio_page.adapter.BannerPagerAdapterRadio;
import com.example.administrator.kaolafm50.discover.radio_page.adapter.RadioRCAdapter;
import com.example.administrator.kaolafm50.discover.radio_page.bean.ChannelInRadio;
import com.example.administrator.kaolafm50.discover.radio_page.bean.Radio;
import com.example.administrator.kaolafm50.discover.radio_page.bean.SpecialInRadio;
import com.example.administrator.kaolafm50.discover.util.DiscoverHttpUtil;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.example.administrator.kaolafm50.others.utils.KalaTask;
import com.example.administrator.kaolafm50.others.utils.LogUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends BaseFragment implements View.OnClickListener{

    private ViewPager radio_vp_banner;
    private TabLayout radio_tl_banner;
    private LinearLayout radio_ll;
    private int i = 0;
    private int count = 1;
    private RadioButton radio_rb_channel1;
    private RadioButton radio_rb_channel2;
    private RadioButton radio_rb_channel3;
    private RadioButton radio_rb_channel4;
    private RadioGroup radio_rg_channel;
//    private RadioSelectChannel channel1;
//    private RadioSelectChannel channel2;
//    private RadioSelectChannel channel3;
//    private RadioSelectChannel channel4;
    private RecyclerView radio_rv;
    private List<ChannelInRadio> list=new ArrayList<>();
    private RadioRCAdapter radioRCAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_radio;
    }

    @Override
    protected void initView() {
        radio_vp_banner = (ViewPager) root.findViewById(R.id.radio_vp_banner);
        radio_tl_banner = (TabLayout) root.findViewById(R.id.radio_tl_banner);
        radio_ll = (LinearLayout) root.findViewById(R.id.radio_ll);

        radio_rg_channel = (RadioGroup) root.findViewById(R.id.radio_rg_channel);
        radio_rb_channel1 = (RadioButton) root.findViewById(R.id.radio_rb_channel1);
        radio_rb_channel2 = (RadioButton) root.findViewById(R.id.radio_rb_channel2);
        radio_rb_channel3 = (RadioButton) root.findViewById(R.id.radio_rb_channel3);
        radio_rb_channel4 = (RadioButton) root.findViewById(R.id.radio_rb_channel4);

        radio_rv = (RecyclerView) root.findViewById(R.id.radio_rv);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        DiscoverHttpUtil.getRadio(new KalaTask.IRequestCallback() {

            @Override
            public void success(Object obj) {
                LogUtil.w("radioJson="+obj.toString());
                try {
                    JSONObject root = new JSONObject(obj.toString());
                    String message = root.getString("message");
                    if (message.equals("success")) {
                        JSONObject result = root.getJSONObject("result");
                        JSONArray dataList = result.getJSONArray("dataList");
                        List<Radio> list = Radio.arrayRadioFromData(dataList.toString());
                        for (int i = 0; i < list.size(); i++) {
                            Radio radio = list.get(i);
                            int componentType = radio.getComponentType();
                            switch (componentType) {
//                                case Radio.ContentType.TYPE_BANNER:
//                                    //加载广告
//                                    showBanner(radio);
//                                    break;
                                case Radio.ContentType.TYPE_CHANNEL:
                                    //加载频道
//                                    showChannelHead(radio);
                                    showChannelBody(radio);
                                    break;
//                                case Radio.ContentType.TYPE_ANCHOR:
//                                    //加载主播
//                                    showAnchor(radio);
//                                    break;
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

    private void showChannelHead(Radio radio) {
        radio_rg_channel.setPadding(30,30,30,30);
        List<SpecialInRadio> specialInRadios = radio.getDataList();
        List<ChannelInRadio> channelInRadios = specialInRadios.get(0).getDataList();
        radio_rb_channel1.setText(channelInRadios.get(0).getName());
        radio_rb_channel2.setText(channelInRadios.get(1).getName());
        radio_rb_channel3.setText(channelInRadios.get(2).getName());
        radio_rb_channel4.setText(channelInRadios.get(3).getName());
    }

    private void showChannelBody(Radio radio) {
        radio_rv.setLayoutManager(new GridLayoutManager(getActivity(),4));
        radio_rv.setPadding(30,30,30,30);
        radioRCAdapter = new RadioRCAdapter(list, getActivity());
        radio_rv.setAdapter(radioRCAdapter);
        list = radio.getDataList().get(1).getDataList();
//        list.add(null);
        final List<ChannelInRadio> list1 = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            list1.add(list.get(i));
        }
//        final List<ChannelInRadio> list2 = list;
        radioRCAdapter.notifyDataSetChanged();

        radioRCAdapter.setOnMyRecycleViewClickListener(new RadioRCAdapter.OnMyRecycleViewClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                int id = v.getId();
                Toast.makeText(getActivity(),"position="+position+"+v.getId()="+id,Toast.LENGTH_SHORT).show();
                if (position==14) {
//                    list=list1;
//                    View childAt7 = radio_rv.getChildAt(7);
//                    ImageView iv_pic = (ImageView) childAt7.findViewById(R.id.adapter_radio_iv_pic);
//                    iv_pic.setImageResource(R.drawable.category_down);
//                    RadioRCAdapter radioRCAdapter1 = new RadioRCAdapter(list1, getActivity());
//                    radio_rv.setAdapter(radioRCAdapter1);
                    list.clear();
                    for (int i=0;i<list1.size()-7;i++) {
                        list.add(list1.get(i));
                    }
                    radioRCAdapter.notifyDataSetChanged();
                }
                if (position==7) {
//                    RadioRCAdapter radioRCAdapter2 = new RadioRCAdapter(list2, getActivity());
//                    radio_rv.setAdapter(radioRCAdapter2);
                    list.clear();
                    for (int i=0;i<list1.size();i++) {
                        list.add(list1.get(i));
                    }
                    radioRCAdapter.notifyDataSetChanged();
                }
            }
        });
        for(int i = 0; i < radio_rv.getChildCount();i++) {
            radio_rv.getChildAt(i).setOnClickListener(this);
        }
//        List<ChannelInRadio> list1 = list.subList(0, 4);
//        List<ChannelInRadio> list2 = list.subList(4, 8);
//        List<ChannelInRadio> list3 = list.subList(8, 12);
//        List<ChannelInRadio> list4 = list.subList(12, 15);
//        channel1 = new RadioSelectChannel(getActivity(), list1);
//        channel2 = new RadioSelectChannel(getActivity(), list2);
//        channel3 = new RadioSelectChannel(getActivity(), list3);
//        channel4 = new RadioSelectChannel(getActivity(), list4);
//        radio_ll.addView(channel1);
//        radio_ll.addView(channel2);
//        radio_ll.addView(channel3);
//        radio_ll.addView(channel4);
//
////        int id = channel4.getChildAt(3).getId();
//        TextView viewById = (TextView) channel4.findViewById(R.id.radio_channel_tv1);
//        viewById.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                radio_ll.removeView(channel3);
//                radio_ll.removeView(channel4);
//            }
//        });


    }

    private void showBanner(Radio radio) {
        List<SpecialInRadio> list = radio.getDataList();
        List<ImageView> imageViews = new ArrayList<>();
        count = list.size();
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageLoader.getInstance().displayImage(list.get(i).getPic(), imageView,
                    ImageUtil.getNormalImageOption());
            imageViews.add(imageView);
            radio_tl_banner.addTab(radio_tl_banner.newTab());
        }
        BannerPagerAdapterRadio bannerPagerAdapterRadio = new BannerPagerAdapterRadio(list, imageViews);
        radio_vp_banner.setAdapter(bannerPagerAdapterRadio);
        radio_tl_banner.setupWithViewPager(radio_vp_banner);
        scrollViewPager();
    }

    private void scrollViewPager() {
        radio_vp_banner.postDelayed(new Runnable() {

            @Override
            public void run() {

                radio_vp_banner.setCurrentItem(++i % count,true);
            }

        }, 2000);
        radio_vp_banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radio_vp_banner.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        radio_vp_banner.setCurrentItem(++i % count);
                    }

                }, 2000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == radio_rv.getChildItemId(radio_rv.getChildAt(0))) {
            Toast.makeText(getActivity(),"dianjile",Toast.LENGTH_SHORT).show();
        }
    }
}

