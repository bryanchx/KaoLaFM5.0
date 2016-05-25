package com.example.administrator.kaolafm50.discover.recommend_page.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 推荐的专辑
 *
 * Created by Liu Jianping
 *
 * @date : 16/5/19.
 */
public class Special implements Parcelable{

    /**
     * weburl : http://m.kaolafm.com/client/special/detail.html?id=1300000001368&type=6
     * area : null
     * listenNum : 0
     * rtype : 2
     * followedNum : 0
     * albumName :
     * cornerMark : 0
     * rid : 1300000001368
     * host : []
     * pic : http://image.kaolafm.net/mz/images/201605/10fc791d-63e2-4f7a-aa35-28f5f2ee29c4/default.jpg
     * num : 0
     * tip :
     * mp3PlayUrl :
     * rvalue : http://m.kaolafm.com/client/special/detail.html?id=1300000001368&type=6
     * rname :
     * des : 昨天爆出一条消息，让微博上的小伙伴们瞬间炸开了锅。霍建华表白林心如！！！！霍建华承认他与林心如的四年恋情，听到这个消息，大家的第一个反应都是，那胡歌怎么办？
     * fansCount : 12558
     * recommendReson :
     * isVanchor : 0
     * likedNum : 7178031
     * avatar : http://image.kaolafm.net/mz/images/201602/5922f2f1-108e-40e8-99c7-ebaecd09d184/default.jpg
     * liveStatus : 0
     * relation : 0
     * gender : 0
     * extraAttributes :
     * desc : 我
     * nickName : 孔垂楠Korn
     * uid : 2418440
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
    private long uid;
    private List<Host> host;

    protected Special(Parcel in) {
        weburl = in.readString();
        listenNum = in.readInt();
        rtype = in.readInt();
        followedNum = in.readInt();
        albumName = in.readString();
        cornerMark = in.readInt();
        rid = in.readLong();
        pic = in.readString();
        num = in.readInt();
        tip = in.readString();
        mp3PlayUrl = in.readString();
        rvalue = in.readString();
        rname = in.readString();
        des = in.readString();
        fansCount = in.readInt();
        recommendReson = in.readString();
        isVanchor = in.readInt();
        likedNum = in.readInt();
        avatar = in.readString();
        liveStatus = in.readInt();
        relation = in.readInt();
        gender = in.readInt();
        extraAttributes = in.readString();
        desc = in.readString();
        nickName = in.readString();
        uid = in.readInt();
    }

    public static final Creator<Special> CREATOR = new Creator<Special>() {

        @Override
        public Special createFromParcel(Parcel in) {
            return new Special(in);
        }

        @Override
        public Special[] newArray(int size) {
            return new Special[size];
        }
    };

    public static Special objectFromData(String str) {

        return new Gson().fromJson(str, Special.class);
    }

    public static List<Special> arraySpecialFromData(String str) {

        Type listType = new TypeToken<ArrayList<Special>>() {

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

    public long getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<Host> getHost() {
        return host;
    }

    public void setHost(List<Host> host) {
        this.host = host;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(weburl);
        dest.writeInt(listenNum);
        dest.writeInt(rtype);
        dest.writeInt(followedNum);
        dest.writeString(albumName);
        dest.writeInt(cornerMark);
        dest.writeLong(rid);
        dest.writeString(pic);
        dest.writeInt(num);
        dest.writeString(tip);
        dest.writeString(mp3PlayUrl);
        dest.writeString(rvalue);
        dest.writeString(rname);
        dest.writeString(des);
        dest.writeInt(fansCount);
        dest.writeString(recommendReson);
        dest.writeInt(isVanchor);
        dest.writeInt(likedNum);
        dest.writeString(avatar);
        dest.writeInt(liveStatus);
        dest.writeInt(relation);
        dest.writeInt(gender);
        dest.writeString(extraAttributes);
        dest.writeString(desc);
        dest.writeString(nickName);
        dest.writeLong(uid);
    }
}
