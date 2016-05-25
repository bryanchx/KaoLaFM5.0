package com.example.administrator.kaolafm50.my.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.my.adapter.HistoryRecycleViewAdapter;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class ListenhistoryFragment extends BaseFragment {

    private RecyclerView listenHistory_rv;
    private List<String> list=new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_listenhistory;
    }

    @Override
    protected void initView() {
        listenHistory_rv = (RecyclerView) root.findViewById(R.id.listenHistory_rv);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

        listenHistory_rv.setLayoutManager(linearLayoutManager);
        HistoryRecycleViewAdapter historyRecycleViewAdapter = new HistoryRecycleViewAdapter(list, getActivity());
        listenHistory_rv.setAdapter(historyRecycleViewAdapter);
        for (int i=0;i<20;i++) {
            list.add(""+i);
        }
        historyRecycleViewAdapter.notifyDataSetChanged();
    }
}
