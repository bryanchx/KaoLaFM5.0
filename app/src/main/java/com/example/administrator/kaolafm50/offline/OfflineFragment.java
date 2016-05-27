package com.example.administrator.kaolafm50.offline;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;
import com.example.administrator.kaolafm50.others.utils.KalaTask;
import com.example.administrator.kaolafm50.others.utils.OKHttpUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfflineFragment extends BaseFragment {
    private SwipeRefreshLayout offline_srl;
    private ListView offline_content_lv;
    private int page;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_offline;
    }

    @Override
    protected void initView() {
        offline_srl = (SwipeRefreshLayout) root.findViewById(R.id.offline_srl);
        offline_content_lv = (ListView) root.findViewById(R.id.offline_content_lv);
        offline_srl.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW);
    }

    @Override
    protected void initEvent() {
        offline_srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                //一般情况下是进行网络请求，如果是请求一个list,下拉刷新是请求第一页的数据
                page=0;

                OKHttpUtil.doGet(OKHttpUtil.URL_BANNER, new KalaTask.IRequestCallback() {

                    @Override
                    public void success(Object obj) {
                        //如果阻塞主线程，那么正在刷新的绘制将会停止
//                        try {
//                            Thread.sleep(3000000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        offline_srl.setRefreshing(false);
                    }

                    @Override
                    public void error(String msg) {

                    }
                });
            }
        });
    }

    @Override
    protected void initData() {

    }
}
