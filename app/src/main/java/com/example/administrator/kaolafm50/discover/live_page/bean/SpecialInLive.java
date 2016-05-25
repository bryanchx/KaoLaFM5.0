package com.example.administrator.kaolafm50.discover.live_page.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2016/5/21.
 */
public class SpecialInLive implements Parcelable {


    /**
     * weburl :
     * area : null
     * listenNum : 0
     * rtype : 5
     * followedNum : 0
     * albumName :
     * cornerMark : 0
     * rid : 1591816658
     * host : []
     * pic : http://image.kaolafm.net/mz/images/201605/b5d4f177-3b4f-4490-a348-c4f5268d0b0c/default.jpg
     * num : 0
     * tip :
     * mp3PlayUrl :
     * rvalue : 1591816658
     * rname : 《欢乐颂》里的纠结：奇点配得上安迪吗？
     * des : 《欢乐颂》里的纠结：奇点配得上安迪吗？
     */

    private String weburl;
//    private Object area;
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
    private List<HostInLive> host;
    /**
     * roomId : 121228
     * period : 1
     * isVanchor : 0
     * showStartTime : 直播中
     * liveDesc : FreshFM新鲜广播1
     * uid : 2740993
     * programName :  FreshFM新鲜广播 | 新浪微博：新鲜广播
     * programDesc : 新鲜广播
     * endtime : 2017-05-13 14:59:58
     * backLiveUrl :
     * guests :
     * shareUrl : http://m.kaolafm.com/share/liveplay/index.html
     * gender : 3
     * isCanSubscribe : 0
     * bgColor :
     * liveId : 1415290026
     * startTime : 1463036515000
     * pushHost : bj.ugclbs.kaolafm.com
     * programPic : http://image.kaolafm.net/mz/images/201604/d652e202-6e37-467a-91b1-ae396181c089/default.jpg
     * avatar : http://image.kaolafm.net/mz/images/201604/5ac80e38-2eda-496f-8576-e84ea7fe0863/default.jpg
     * lockType : 0
     * isAlreadyFollowed : 0
     * liveName : FreshFM新鲜广播
     * accessKey : aaf30a55ec51aa6f
     * isAlreadySubscribe : 0
     * programSharedNum : 25
     * programFollowedNum : 46
     * liveUrl : http://ugclbs.kaolafm.com/aaf30a55ec51aa6f/1415290026_1595817131/playlist.m3u8
     * duration : 0
     * canPlayBack : 0
     * status : 1
     * onLineNum : 114
     * finshTime : 1494658798000
     * programLikedNum : 25227
     * livePic : http://image.kaolafm.net/mz/images/201604/d652e202-6e37-467a-91b1-ae396181c089/default.jpg
     * serveTime : 1463851160591
     * comperes : 24小时华语好歌
     * subscribeNum : 0
     * albumId : 1100000165971
     * programId : 1595817131
     * begintime : 2016-05-12 15:01:55
     * timeLength :
     */

    private long roomId;
    private int period;
    private int isVanchor;
    private String showStartTime;
    private String liveDesc;
    private long uid;
    private String programName;
    private String programDesc;
    private String endtime;
    private String backLiveUrl;
    private String guests;
    private String shareUrl;
    private int gender;
    private int isCanSubscribe;
    private String bgColor;
    private long liveId;
    private long startTime;
    private String pushHost;
    private String programPic;
    private String avatar;
    private int lockType;
    private int isAlreadyFollowed;
    private String liveName;
    private String accessKey;
    private int isAlreadySubscribe;
    private int programSharedNum;
    private int programFollowedNum;
    private String liveUrl;
    private int duration;
    private int canPlayBack;
    private int status;
    private int onLineNum;
    private long finshTime;
    private int programLikedNum;
    private String livePic;
    private long serveTime;
    private String comperes;
    private int subscribeNum;
    private long albumId;
    private long programId;
    private String begintime;
    private String timeLength;
//    private DateDtoBean dateDto;
    private DateDtoInLive dateDtoInLive;
    /**
     * dataList : []
     * dateDto : {}
     */
    /**
     * fansCount : 2097
     * recommendReson :
     * likedNum : 2712185
     * liveStatus : 0
     * relation : 0
     * extraAttributes :
     * desc : TA懒懒的什么也没写
     * nickName : 公孙大娘
     */

    private int fansCount;
    private String recommendReson;
    private int likedNum;
    private int liveStatus;
    private int relation;
    private String extraAttributes;
    private String desc;
    private String nickName;

    private List<HostInDataInlive> dataList;




//    public static SpecialInLive objectFromData(String str) {
//
//        return new Gson().fromJson(str, SpecialInLive.class);
//    }
//
//    public static List<SpecialInLive> arraySpecialInLiveFromData(String str) {
//
//        Type listType = new TypeToken<ArrayList<SpecialInLive>>() {
//
//        }.getType();
//
//        return new Gson().fromJson(str, listType);
//    }


    protected SpecialInLive(Parcel in) {
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
        roomId = in.readLong();
        period = in.readInt();
        isVanchor = in.readInt();
        showStartTime = in.readString();
        liveDesc = in.readString();
        uid = in.readLong();
        programName = in.readString();
        programDesc = in.readString();
        endtime = in.readString();
        backLiveUrl = in.readString();
        guests = in.readString();
        shareUrl = in.readString();
        gender = in.readInt();
        isCanSubscribe = in.readInt();
        bgColor = in.readString();
        liveId = in.readLong();
        startTime = in.readLong();
        pushHost = in.readString();
        programPic = in.readString();
        avatar = in.readString();
        lockType = in.readInt();
        isAlreadyFollowed = in.readInt();
        liveName = in.readString();
        accessKey = in.readString();
        isAlreadySubscribe = in.readInt();
        programSharedNum = in.readInt();
        programFollowedNum = in.readInt();
        liveUrl = in.readString();
        duration = in.readInt();
        canPlayBack = in.readInt();
        status = in.readInt();
        onLineNum = in.readInt();
        finshTime = in.readLong();
        programLikedNum = in.readInt();
        livePic = in.readString();
        serveTime = in.readLong();
        comperes = in.readString();
        subscribeNum = in.readInt();
        albumId = in.readLong();
        programId = in.readLong();
        begintime = in.readString();
        timeLength = in.readString();
        fansCount = in.readInt();
        recommendReson = in.readString();
        likedNum = in.readInt();
        liveStatus = in.readInt();
        relation = in.readInt();
        extraAttributes = in.readString();
        desc = in.readString();
        nickName = in.readString();
    }

    public static final Creator<SpecialInLive> CREATOR = new Creator<SpecialInLive>() {

        @Override
        public SpecialInLive createFromParcel(Parcel in) {
            return new SpecialInLive(in);
        }

        @Override
        public SpecialInLive[] newArray(int size) {
            return new SpecialInLive[size];
        }
    };

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

//    public Object getArea() {
//        return area;
//    }
//
//    public void setArea(Object area) {
//        this.area = area;
//    }

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

    public void setRid(int rid) {
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

    public List<HostInLive> getHost() {
        return host;
    }

    public void setHost(List<HostInLive> host) {
        this.host = host;
    }


    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getIsVanchor() {
        return isVanchor;
    }

    public void setIsVanchor(int isVanchor) {
        this.isVanchor = isVanchor;
    }

    public String getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(String showStartTime) {
        this.showStartTime = showStartTime;
    }

    public String getLiveDesc() {
        return liveDesc;
    }

    public void setLiveDesc(String liveDesc) {
        this.liveDesc = liveDesc;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDesc() {
        return programDesc;
    }

    public void setProgramDesc(String programDesc) {
        this.programDesc = programDesc;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getBackLiveUrl() {
        return backLiveUrl;
    }

    public void setBackLiveUrl(String backLiveUrl) {
        this.backLiveUrl = backLiveUrl;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getIsCanSubscribe() {
        return isCanSubscribe;
    }

    public void setIsCanSubscribe(int isCanSubscribe) {
        this.isCanSubscribe = isCanSubscribe;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public long getLiveId() {
        return liveId;
    }

    public void setLiveId(int liveId) {
        this.liveId = liveId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getPushHost() {
        return pushHost;
    }

    public void setPushHost(String pushHost) {
        this.pushHost = pushHost;
    }

    public String getProgramPic() {
        return programPic;
    }

    public void setProgramPic(String programPic) {
        this.programPic = programPic;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getLockType() {
        return lockType;
    }

    public void setLockType(int lockType) {
        this.lockType = lockType;
    }

    public int getIsAlreadyFollowed() {
        return isAlreadyFollowed;
    }

    public void setIsAlreadyFollowed(int isAlreadyFollowed) {
        this.isAlreadyFollowed = isAlreadyFollowed;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public int getIsAlreadySubscribe() {
        return isAlreadySubscribe;
    }

    public void setIsAlreadySubscribe(int isAlreadySubscribe) {
        this.isAlreadySubscribe = isAlreadySubscribe;
    }

    public int getProgramSharedNum() {
        return programSharedNum;
    }

    public void setProgramSharedNum(int programSharedNum) {
        this.programSharedNum = programSharedNum;
    }

    public int getProgramFollowedNum() {
        return programFollowedNum;
    }

    public void setProgramFollowedNum(int programFollowedNum) {
        this.programFollowedNum = programFollowedNum;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCanPlayBack() {
        return canPlayBack;
    }

    public void setCanPlayBack(int canPlayBack) {
        this.canPlayBack = canPlayBack;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOnLineNum() {
        return onLineNum;
    }

    public void setOnLineNum(int onLineNum) {
        this.onLineNum = onLineNum;
    }

    public long getFinshTime() {
        return finshTime;
    }

    public void setFinshTime(long finshTime) {
        this.finshTime = finshTime;
    }

    public int getProgramLikedNum() {
        return programLikedNum;
    }

    public void setProgramLikedNum(int programLikedNum) {
        this.programLikedNum = programLikedNum;
    }

    public String getLivePic() {
        return livePic;
    }

    public void setLivePic(String livePic) {
        this.livePic = livePic;
    }

    public long getServeTime() {
        return serveTime;
    }

    public void setServeTime(long serveTime) {
        this.serveTime = serveTime;
    }

    public String getComperes() {
        return comperes;
    }

    public void setComperes(String comperes) {
        this.comperes = comperes;
    }

    public int getSubscribeNum() {
        return subscribeNum;
    }

    public void setSubscribeNum(int subscribeNum) {
        this.subscribeNum = subscribeNum;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
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

    public int getLikedNum() {
        return likedNum;
    }

    public void setLikedNum(int likedNum) {
        this.likedNum = likedNum;
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

//    public DateDtoBean getDateDto() {
//        return dateDto;
//    }
//
//    public void setDateDto(DateDtoBean dateDto) {
//        this.dateDto = dateDto;
//    }
    public DateDtoInLive getDateDtoInLive() {
        return dateDtoInLive;
    }

    public void setDateDtoInLive(DateDtoInLive dateDtoInLive) {
        this.dateDtoInLive = dateDtoInLive;
    }

    public List<HostInDataInlive> getDataList() {
        return dataList;
    }

    public void setDataList(List<HostInDataInlive> dataList) {
        this.dataList = dataList;
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
        dest.writeLong(roomId);
        dest.writeInt(period);
        dest.writeInt(isVanchor);
        dest.writeString(showStartTime);
        dest.writeString(liveDesc);
        dest.writeLong(uid);
        dest.writeString(programName);
        dest.writeString(programDesc);
        dest.writeString(endtime);
        dest.writeString(backLiveUrl);
        dest.writeString(guests);
        dest.writeString(shareUrl);
        dest.writeInt(gender);
        dest.writeInt(isCanSubscribe);
        dest.writeString(bgColor);
        dest.writeLong(liveId);
        dest.writeLong(startTime);
        dest.writeString(pushHost);
        dest.writeString(programPic);
        dest.writeString(avatar);
        dest.writeInt(lockType);
        dest.writeInt(isAlreadyFollowed);
        dest.writeString(liveName);
        dest.writeString(accessKey);
        dest.writeInt(isAlreadySubscribe);
        dest.writeInt(programSharedNum);
        dest.writeInt(programFollowedNum);
        dest.writeString(liveUrl);
        dest.writeInt(duration);
        dest.writeInt(canPlayBack);
        dest.writeInt(status);
        dest.writeInt(onLineNum);
        dest.writeLong(finshTime);
        dest.writeInt(programLikedNum);
        dest.writeString(livePic);
        dest.writeLong(serveTime);
        dest.writeString(comperes);
        dest.writeInt(subscribeNum);
        dest.writeLong(albumId);
        dest.writeLong(programId);
        dest.writeString(begintime);
        dest.writeString(timeLength);
        dest.writeInt(fansCount);
        dest.writeString(recommendReson);
        dest.writeInt(likedNum);
        dest.writeInt(liveStatus);
        dest.writeInt(relation);
        dest.writeString(extraAttributes);
        dest.writeString(desc);
        dest.writeString(nickName);
    }


    public static class DateDtoBean {

        public static DateDtoBean objectFromData(String str) {

            return new Gson().fromJson(str, DateDtoBean.class);
        }

        public static List<DateDtoBean> arrayDateDtoBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DateDtoBean>>() {

            }.getType();

            return new Gson().fromJson(str, listType);
        }
    }
}
