package com.example.administrator.kaolafm50.discover.util;

import com.example.administrator.kaolafm50.others.utils.HttpUtil;
import com.example.administrator.kaolafm50.others.utils.KalaTask;

/**
 * Created by Administrator on 16-5-24.
 */
public class OtherUtil {
    public static String APK_UPDATEURL="http://api.kaolafm.com/api/v4/upgrade/check?installid=0002sc3X&udid=51bc5968874c43b5bc11b7eb84387f3b&sessionid=51bc5968874c43b5bc11b7eb84387f3b1464050075800&imsi=460074611085122&operator=0&lon=0.0&lat=0.0&network=1&timestamp=1464053051&sign=7ec3b5a1e1ec4ec3718ff17b35661a74&resolution=720*1242&devicetype=0&channel=A-myapp&version=4.7.1&appid=0&";
    public static void updateApk(KalaTask.IRequestCallback callback){

        KalaTask.IRequest iRequest = new KalaTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(APK_UPDATEURL);
            }
        };
        KalaTask task = new KalaTask(iRequest, callback);
        task.execute();
    }

    public static void getApk(){

    }
}
