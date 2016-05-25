package com.example.administrator.kaolafm50.discover.live_page.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2016/5/21.
 */
public class HostInLive {

    /**
     * des :
     * img :
     * name : 连清川
     */

    private String des;
    private String img;
    private String name;

    public static HostInLive objectFromData(String str) {

        return new Gson().fromJson(str, HostInLive.class);
    }

    public static List<HostInLive> arrayHostInLiveFromData(String str) {

        Type listType = new TypeToken<ArrayList<HostInLive>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
