package com.example.administrator.kaolafm50.discover.live_page.ui;


import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.adapter.MyBaseAdapter;
import com.example.administrator.kaolafm50.discover.live_page.bean.HostInDataInlive;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TomorrowFragment extends BaseFragment {
    private List<HostInDataInlive> listDate=LiveFragment.getList2();

    private ListView listView;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tomorrow;
    }

    @Override
    protected void initView() {
        listView = (ListView) root.findViewById(R.id.live_tomorrow_lv);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        MyBaseAdapter myBaseAdapter2 = new MyBaseAdapter(getActivity(), listDate);
        listView.setAdapter(myBaseAdapter2);
        myBaseAdapter2.notifyDataSetChanged();
    }

}
