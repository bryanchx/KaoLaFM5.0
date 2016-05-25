package com.example.administrator.kaolafm50.discover.anchor_page.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-23.
 */
public class SpecialInAnchor {

    /**
     * weburl : http://m.kaolafm.com/client/special/detail.html?id=1300000001355&type=6
     * area : null
     * listenNum : 0
     * rtype : 2
     * followedNum : 0
     * albumName :
     * cornerMark : 0
     * rid : 1300000001355
     * host : []
     * pic : http://image.kaolafm.net/mz/images/201605/3b08e538-e03f-4de7-92b4-0bd8eb28b834/default.jpg
     * num : 0
     * tip :
     * mp3PlayUrl :
     * rvalue : http://m.kaolafm.com/client/special/detail.html?id=1300000001355&type=6
     * rname : 听了会怀孕的十大自媒体电台
     * des : 新世相、政见、微思客……很多人都知道这些是著名的公众号，现在，播客版出来了，好内容不仅可以看，更可以听！一起来近距离感受相见恨晚的主播的魅力吧，本期专题为你盘点十大高逼格自媒体电台，欲听从速。
     * fansCount : 1465
     * recommendReson : 前凤凰卫视知性女主播
     * isVanchor : 0
     * likedNum : 13668
     * avatar : http://image.kaolafm.net/mz/images/201510/8e8613eb-e755-4f7e-992f-2c1f894baa4b/default.png
     * liveStatus : 0
     * relation : 0
     * gender : 1
     * extraAttributes :
     * desc : TA懒懒的什么也没写
     * nickName : 樊素
     * uid : 2065987
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
    private int fansCount;
    private String recommendReson;
    private int isVanchor;
    private int likedNum;
    private String avatar;
    private int liveStatus;
    private int relation;
    private int gender;
    private String extraAttributes;
    private String desc;
    private String nickName;
    private int uid;
    private List<HostInAnchor> host;

    public static SpecialInAnchor objectFromData(String str) {

        return new Gson().fromJson(str, SpecialInAnchor.class);
    }

    public static List<SpecialInAnchor> arraySpecialInAnchorFromData(String str) {

        Type listType = new TypeToken<ArrayList<SpecialInAnchor>>() {

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

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public String getRecommendReson() {
        return recommendReson;
    }

    public void setRecommendReson(String recommendReson) {
        this.recommendReson = recommendReson;
    }

    public int getIsVanchor() {
        return isVanchor;
    }

    public void setIsVanchor(int isVanchor) {
        this.isVanchor = isVanchor;
    }

    public int getLikedNum() {
        return likedNum;
    }

    public void setLikedNum(int likedNum) {
        this.likedNum = likedNum;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(int liveStatus) {
        this.liveStatus = liveStatus;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(String extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<HostInAnchor> getHost() {
        return host;
    }

    public void setHost(List<HostInAnchor> host) {
        this.host = host;
    }
}
