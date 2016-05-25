package com.example.administrator.kaolafm50.discover.radio_page.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-23.
 */
public class SpecialInRadio {

    /**
     * weburl :
     * area : null
     * listenNum : 0
     * rtype : 11
     * followedNum : 0
     * albumName :
     * cornerMark : 3
     * rid : 1600000000510
     * host : []
     * pic : http://image.kaolafm.net/mz/images/201605/a9666b60-c81f-4e2c-8b3a-77d35c7f8173/default.jpg
     * num : 0
     * tip :
     * mp3PlayUrl :
     * rvalue : 1600000000510
     * rname : 央广中国之声
     * des : 中央人民广播电台中国之声
     * type : 1
     * typeName : 类型
     * dataList : []
     */

    private String weburl;
    private Object area;
    private int listenNum;
    private int rtype;
    private int followedNum;
    private String albumName;
    private int cornerMark;
    private long rid;
    private String pic;
    private int num;
    private String tip;
    private String mp3PlayUrl;
    private String rvalue;
    private String rname;
    private String des;
    private int type;
    private String typeName;
    private List<HostInRadio> host;
    private List<ChannelInRadio> dataList;

    public static SpecialInRadio objectFromData(String str) {

        return new Gson().fromJson(str, SpecialInRadio.class);
    }

    public static List<SpecialInRadio> arraySpecialInRadioFromData(String str) {

        Type listType = new TypeToken<ArrayList<SpecialInRadio>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public int getListenNum() {
        return listenNum;
    }

    public void setListenNum(int listenNum) {
        this.listenNum = listenNum;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public int getFollowedNum() {
        return followedNum;
    }

    public void setFollowedNum(int followedNum) {
        this.followedNum = followedNum;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getCornerMark() {
        return cornerMark;
    }

    public void setCornerMark(int cornerMark) {
        this.cornerMark = cornerMark;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMp3PlayUrl() {
        return mp3PlayUrl;
    }

    public void setMp3PlayUrl(String mp3PlayUrl) {
        this.mp3PlayUrl = mp3PlayUrl;
    }

    public String getRvalue() {
        return rvalue;
    }

    public void setRvalue(String rvalue) {
        this.rvalue = rvalue;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<HostInRadio> getHost() {
        return host;
    }

    public void setHost(List<HostInRadio> host) {
        this.host = host;
    }

    public List<ChannelInRadio> getDataList() {
        return dataList;
    }

    public void setDataList(List<ChannelInRadio> dataList) {
        this.dataList = dataList;
    }
}
