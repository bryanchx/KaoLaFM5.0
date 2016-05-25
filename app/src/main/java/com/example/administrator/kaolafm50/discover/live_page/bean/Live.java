package com.example.administrator.kaolafm50.discover.live_page.bean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2016/5/21.
 */
public class Live {

    /**
     * contentType : 1
     * relatedValue : 0
     * icon :
     * id : 346
     * componentType : 13
     * desc :
     * pic :
     * dataList : []
     * moreType : 1
     * count : 0
     * contentSourceId : 6
     * name : 滚动banner
     * hasmore : 0
     */

    private int contentType;
    private String relatedValue;
    private String icon;
    private int id;
    private int componentType;
    private String desc;
    private String pic;
    private int moreType;
    private int count;
    private int contentSourceId;
    private String name;
    private int hasmore;
    private List<SpecialInLive> dataList;

    public static Live objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, Live.class);
    }

    public static List<Live> arrayLiveFromData(String str) {

        Type listType = new com.google.gson.reflect.TypeToken<ArrayList<Live>>() {

        }.getType();

        return new com.google.gson.Gson().fromJson(str, listType);
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

    public int getId() {
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

    public int getContentSourceId() {
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

    public List<SpecialInLive> getDataList() {
        return dataList;
    }

    public void setDataList(List<SpecialInLive> dataList) {
        this.dataList = dataList;
    }

    /**
     * 定义contentType在
     */
    public static class ContentType{

        /**
         * 一张广告图片
         */
        public static final int TYPE_IMAGE=16;
//        /**
//         * 一张广告图片
//         */
        public static final int TYPE_PANEL=3;
        /**
         * 线上沙龙
         */
        public static final int TYPE_ONLINEDRAGON=36;
        /**
         * 广告
         */
        public static final int TYPE_BANNER=13;
        /**
         * 正在直播
         */
        public static final int TYPE_ISLIVING=14;
        /**
         * 热门主播
         */
        public static final int TYPE_ANCHOR=18;
        /**
         * 精选直播预告
         */
        public static final int TYPE_ADVANCE_NOTICE=35;
//        /**
//         * 专题、活动、商城
//         */
//        public static final int TYPE_ACTIVE=27;
//        /**
//         * 猜你喜欢的
//         */
//        public static final int TYPE_ANCHOR=26;
//        /**
//         *自定义栏目
//         */
//        public static final int TYPE_CUSTOM=32;

    }
}
