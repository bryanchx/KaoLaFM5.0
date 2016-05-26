package com.example.administrator.kaolafm50.others.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 16-5-20.
 */
public class FileUtil {
    public static final File DIR_CACHE=createDir("cache");
    public static final File IMAGE_DIR=createDir("image");
    public static final File APK_DIR=createDir("apk");
    public static final File AUDIO_DIR=createDir("audio");
    public static final File VIDEO_DIR=createDir("video");
    /**
     * 获取sd卡目录
     * @return
     */
    public static File getSDCardDir(){
        //获取存储转态
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File directory = Environment.getExternalStorageDirectory();
            return directory;
        }
        LogUtil.w("没有sd卡！");
        return null;
    }
    /**
     * 获取项目目录
     */
    public static File getAppDir(){
        File sdCardDir=getSDCardDir();
        if (sdCardDir==null) {
            return null;
        }
        File appDir = new File(sdCardDir, "Kala_1602");
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        return appDir;
    }

    public static File createDir(String name){
        File file = new File(getAppDir(), name);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 使用url获取文件名
     */
    public static String getFileName(String url,String rename,boolean useHashCode){
        if (url==null) {
            return null;
        }
        if (useHashCode) {
            return ""+url.hashCode();
        }else{
            int last = url.lastIndexOf(".");
            return rename+url.substring(last);
        }
    }
}
