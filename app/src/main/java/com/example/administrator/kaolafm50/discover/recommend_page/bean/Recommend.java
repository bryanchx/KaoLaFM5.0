package com.example.administrator.kaolafm50.discover.recommend_page.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu Jianping
 *
 * @date : 16/5/19.
 */
public class Recommend {


    /**
     * contentType : 1
     * relatedValue : 0
     * icon :
     * id : 238
     * componentType : 1
     * desc :
     * pic :
     * dataList : []
     * moreType : 1
     * count : 0
     * contentSourceId : 6
     * name : 顶部banner
     * hasmore : 0
     */

    private int contentType;
    private String relatedValue;
    private String icon;
    private long id;
    private int componentType;
    private String desc;
    private String pic;
    private int moreType;
    private int count;
    private long contentSourceId;
    private String name;
    private int hasmore;
    private List<Special> dataList;

    public static Recommend objectFromData(String str) {

        return new Gson().fromJson(str, Recommend.class);
    }

    public static List<Recommend> arrayRecommendFromData(String str) {

        Type listType = new TypeToken<ArrayList<Recommend>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getRelatedValue() {
        return relatedValue;
    }

    public void setRelatedValue(String relatedValue) {
        this.relatedValue = relatedValue;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComponentType() {
        return componentType;
    }

    public void setComponentType(int componentType) {
        this.componentType = componentType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getMoreType() {
        return moreType;
    }

    public void setMoreType(int moreType) {
        this.moreType = moreType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getContentSourceId() {
        return contentSourceId;
    }

    public void setContentSourceId(int contentSourceId) {
        this.contentSourceId = contentSourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHasmore() {
        return hasmore;
    }

    public void setHasmore(int hasmore) {
        this.hasmore = hasmore;
    }

    public List<Special> getDataList() {
        return dataList;
    }

    public void setDataList(List<Special> dataList) {
        this.dataList = dataList;
    }

    /**
     * 定义contentType在
     */
    public static class ContentType{

        /**
         * 一张广告图片
         */
        public static final int TYPE_IMAGE=8;
        /**
         * 一张广告图片
         */
        public static final int TYPE_PANEL=3;
        /**
         * 猜你喜欢的
         */
        public static final int TYPE_GUESS=29;
        /**
         * 广告
         */
        public static final int TYPE_BANNER=1;
        /**
         * 快捷入口
         */
        public static final int TYPE_ENTER=28;
        /**
         * 滚动快讯
         */
        public static final int TYPE_SCROLL=31;
        /**
         * 专题、活动、商城
         */
        public static final int TYPE_ACTIVE=27;
        /**
         * 猜你喜欢的
         */
        public static final int TYPE_ANCHOR=26;
        /**
         *自定义栏目
         */
        public static final int TYPE_CUSTOM=32;

    }
}


