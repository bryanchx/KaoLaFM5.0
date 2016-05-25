package com.example.administrator.kaolafm50.discover.live_page.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2016/5/22.
 */
public class DateDtoInLive {

    /**
     * weekDay : 明天
     * dateTime : 05月23日
     * time : 2016-05-23
     */

    private String weekDay;
    private String dateTime;
    private String time;

    public static DateDtoInLive objectFromData(String str) {

        return new Gson().fromJson(str, DateDtoInLive.class);
    }

    public static List<DateDtoInLive> arrayDateDtoInLiveFromData(String str) {

        Type listType = new TypeToken<ArrayList<DateDtoInLive>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
