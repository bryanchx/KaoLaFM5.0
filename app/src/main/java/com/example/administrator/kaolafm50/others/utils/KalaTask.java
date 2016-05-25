package com.example.administrator.kaolafm50.others.utils;

import android.os.AsyncTask;

/**
 * Created by Administrator on 16-5-19.
 */
public class KalaTask extends AsyncTask<Void,Void,Object>{
    private IRequest request;
    private IRequestCallback requestCallback;

    public KalaTask(IRequest request,IRequestCallback requestCallback) {
        if (request==null||requestCallback==null) {
            throw new NullPointerException("接口是空的");
        }
        this.request = request;
        this.requestCallback=requestCallback;
    }

    @Override
    protected Object doInBackground(Void... params) {
        return request.doRequest();
    }

    @Override
    protected void onPostExecute(Object o) {
        if (o == null) {
            requestCallback.error("请求失败了！");
        } else {
            requestCallback.success(o);
        }
    }

    public interface IRequest{
        //执行请求
        Object doRequest();
    }

    public interface IRequestCallback{
        void success(Object obj);
        void error(String msg);
    }

    /**
     * 下载监听
     */
    public interface IDownLoadListener{
        void start();
        void updateProgress(int progress);
        void complete();
        void error();
    }
}
