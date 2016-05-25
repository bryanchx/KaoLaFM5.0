package com.example.administrator.kaolafm50.discover.ui;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.adapter.CommFragmentPagerAdapter;
import com.example.administrator.kaolafm50.discover.anchor_page.ui.AnchorFragment;
import com.example.administrator.kaolafm50.discover.live_page.ui.LiveFragment;
import com.example.administrator.kaolafm50.discover.radio_page.ui.RadioFragment;
import com.example.administrator.kaolafm50.discover.recommend_page.ui.RecommendFragment;
import com.example.administrator.kaolafm50.discover.type_page.TypeFragment;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;
import com.example.administrator.kaolafm50.others.ui.HomeActivity;
import com.example.administrator.kaolafm50.others.widget.KaoLaSlidePanelLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends BaseFragment {

    private EditText discover_search_et;
    private ImageView discover_play_iv;
    private TabLayout discover_content_tl;
    private ViewPager discover_content_vp;
    private CommFragmentPagerAdapter pagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initView() {
        discover_search_et = (EditText) root.findViewById(R.id.discover_search_et);
        discover_play_iv = (ImageView) root.findViewById(R.id.discover_play_iv);
        discover_content_tl = (TabLayout) root.findViewById(R.id.discover_content_tl);
        discover_content_vp = (ViewPager) root.findViewById(R.id.discover_content_vp);

        //下载测试
//        new KalaTask(new KalaTask.IRequest() {
//
//            @Override
//            public Object doRequest() {
//                return HttpUtil.downLoadFile("http://image.kaolafm.net/mz/audios/201605/58ae2ebc-75a5-4da3-af45-07e30905f7ce.mp3",
//                        FileUtil.AUDIO_DIR, "test.mp3", new KalaTask.IDownLoadListener() {
//
//                            @Override
//                            public void start() {
//
//                            }
//
//                            @Override
//                            public void updateProgress(int progress) {
//
//                            }
//
//                            @Override
//                            public void complete() {
//
//                            }
//
//                            @Override
//                            public void error() {
//
//                            }
//                        });
//
//            }
//        }, new KalaTask.IRequestCallback() {
//
//            @Override
//            public void success(Object obj) {
//
//            }
//
//            @Override
//            public void error(String msg) {
//
//            }
//        }).execute();

    }

    @Override
    protected void initEvent() {
        discover_content_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                HomeActivity homeActivity= (HomeActivity) getActivity();
                homeActivity.home_spl.setIindexListener(new KaoLaSlidePanelLayout.IindexListener() {

                    @Override
                    public int getIndex() {
                        return position;
                    }
                });
                discover_content_tl.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        discover_content_tl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                discover_content_vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
        discover_content_tl.addTab(discover_content_tl.newTab().setText(R.string.dicover_tab_recommend));
        discover_content_tl.addTab(discover_content_tl.newTab().setText(R.string.dicover_tab_type));
        discover_content_tl.addTab(discover_content_tl.newTab().setText(R.string.dicover_tab_radio));
        discover_content_tl.addTab(discover_content_tl.newTab().setText(R.string.dicover_tab_live));
        discover_content_tl.addTab(discover_content_tl.newTab().setText(R.string.dicover_tab_anchor));

        List<Fragment> list=new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new TypeFragment());
        list.add(new RadioFragment());
        list.add(new LiveFragment());
        list.add(new AnchorFragment());
        pagerAdapter = new CommFragmentPagerAdapter(getFragmentManager(), list);
        discover_content_vp.setAdapter(pagerAdapter);
    }

}
