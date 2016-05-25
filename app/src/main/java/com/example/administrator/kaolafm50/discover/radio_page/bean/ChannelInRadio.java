package com.example.administrator.kaolafm50.discover.radio_page.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-23.
 */
public class ChannelInRadio {

    /**
     * type : 2
     * pic : http://image.kaolafm.net/mz/images/201511/8c369f91-d025-4ccd-a557-a2cdac86c690/default.jpg
     * name : 交通台
     * id : 6
     */

    private int type;
    private String pic;
    private String name;
    private int id;

    public static ChannelInRadio objectFromData(String str) {

        return new Gson().fromJson(str, ChannelInRadio.class);
    }

    public static List<ChannelInRadio> arrayChannelInRadioFromData(String str) {

        Type listType = new TypeToken<ArrayList<ChannelInRadio>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
