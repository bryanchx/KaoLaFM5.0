package com.example.administrator.kaolafm50.others.utils;

import android.util.Log;

/**
 * Created by Administrator on 16-5-19.
 */
public class LogUtil {
    /**
     * 调试开关
     */
    public static final boolean idDebug=true;
    public static final String TAG="LogUtil";
    public static void w(String msg){
        if (idDebug) {
            Log.w(TAG,"fatal-i:"+msg);
        }
    }
    public static void e(String msg){
        if (idDebug) {
            Log.e(TAG,"fatal-e:"+msg);
        }
    }

}
