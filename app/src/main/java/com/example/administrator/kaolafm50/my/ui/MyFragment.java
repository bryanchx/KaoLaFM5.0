package com.example.administrator.kaolafm50.my.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.my.adapter.MyViewPagerAdapter;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends BaseFragment {


private RelativeLayout my_rl_upper;
    private TabLayout my_tl;
    private ViewPager my_vp;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        my_rl_upper= (RelativeLayout) root.findViewById(R.id.my_rl_upper);
        my_tl = (TabLayout) root.findViewById(R.id.my_tl);
        my_vp = (ViewPager) root.findViewById(R.id.my_vp);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        fragments.add(new ListenhistoryFragment());
        fragments.add(new SubscribeFragment());
        fragments.add(new ConnectionFragment());

        titles.add("收听历史");
        titles.add("订阅");
        titles.add("收藏");
        my_tl.setTabMode(TabLayout.MODE_FIXED);
        my_tl.addTab(my_tl.newTab().setText(titles.get(0)));
        my_tl.addTab(my_tl.newTab().setText(titles.get(1)));
        my_tl.addTab(my_tl.newTab().setText(titles.get(2)));

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments,titles);
        my_vp.setAdapter(myViewPagerAdapter);
        my_vp.setCurrentItem(0);
        my_tl.setupWithViewPager(my_vp);
    }
}
