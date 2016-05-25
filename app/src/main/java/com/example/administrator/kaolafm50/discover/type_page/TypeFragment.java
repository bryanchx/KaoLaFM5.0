package com.example.administrator.kaolafm50.discover.type_page;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.util.DiscoverHttpUtil;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;
import com.example.administrator.kaolafm50.others.utils.KalaTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TypeFragment extends BaseFragment {


    private RecyclerView type_rv;
    private List<Type> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_type;
    }

    @Override
    protected void initView() {
        type_rv = (RecyclerView) root.findViewById(R.id.type_rv);
        new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        final TypeAdapter typeAdapter = new TypeAdapter(getActivity(), list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        type_rv.setLayoutManager(gridLayoutManager);
        type_rv.setAdapter(typeAdapter);
        type_rv.setPadding(30,30,30,30);
        DiscoverHttpUtil.getType(new KalaTask.IRequestCallback() {
            @Override
            public void success(Object obj) {
                try {
                    JSONObject root=new JSONObject(obj.toString());
                    String message = root.getString("message");
                    if (message.equals("success")) {
                        JSONObject result = root.getJSONObject("result");
                        JSONArray dataList = result.getJSONArray("dataList");
                        JSONObject o= (JSONObject) dataList.get(0);
                        JSONArray dataList1 = o.getJSONArray("dataList");
                        list = Type.arrayTypeFromData(dataList1.toString());
                        typeAdapter.notifyDataSetChanged();
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
}
