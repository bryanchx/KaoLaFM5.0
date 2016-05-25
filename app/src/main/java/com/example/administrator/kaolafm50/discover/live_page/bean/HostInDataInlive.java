package com.example.administrator.kaolafm50.discover.live_page.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2016/5/22.
 */
public class HostInDataInlive {

    /**
     * roomId : 165532
     * period : 49
     * isVanchor : 0
     * showStartTime : 明天12:30开播
     * liveDesc :
     * uid : 2777912
     * programName : 愚人刧的直播
     * programDesc :
     * endtime : 2016-05-23 13:30:00
     * backLiveUrl :
     * guests :
     * shareUrl : http://m.kaolafm.com/share/liveplay/index.html
     * gender : 0
     * isCanSubscribe : 0
     * bgColor :
     * liveId : 1451098056
     * startTime : 1463977800000
     * pushHost : bj.ugclbs.kaolafm.com
     * programPic : http://image.kaolafm.net/mz/images/201605/74d2dabb-0fda-411d-b9a7-e650e53c6203/default.jpg
     * avatar : http://image.kaolafm.net/mz/images/201605/74d2dabb-0fda-411d-b9a7-e650e53c6203/default.jpg
     * lockType : 0
     * isAlreadyFollowed : 0
     * liveName : 愚人刧的私人直播
     * accessKey : aaf30a55ec51aa6f
     * isAlreadySubscribe : 0
     * programSharedNum : 0
     * programFollowedNum : 35
     * liveUrl : http://ugclbs.kaolafm.com/aaf30a55ec51aa6f/1451098056_1589429374/playlist.m3u8
     * duration : 0
     * canPlayBack : 0
     * status : 6
     * onLineNum : 0
     * finshTime : 1463981400000
     * programLikedNum : 0
     * livePic : http://image.kaolafm.net/mz/images/201605/74d2dabb-0fda-411d-b9a7-e650e53c6203/default.jpg
     * serveTime : 1463851083808
     * comperes : 愚人刧
     * subscribeNum : 0
     * albumId : 0
     * programId : 1589429374
     * begintime : 2016-05-23 12:30:00
     * timeLength :
     */

    private long roomId;
    private int period;
    private int isVanchor;
    private String showStartTime;
    private String liveDesc;
    private int uid;
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




    public static HostInDataInlive objectFromData(String str) {

        return new Gson().fromJson(str, HostInDataInlive.class);
    }

    public static List<HostInDataInlive> arrayHostInDataInliveFromData(String str) {

        Type listType = new TypeToken<ArrayList<HostInDataInlive>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
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

    public int getUid() {
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

    public void setAlbumId(int albumId) {
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



}
