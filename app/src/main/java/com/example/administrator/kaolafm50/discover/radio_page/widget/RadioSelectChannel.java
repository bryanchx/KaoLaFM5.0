package com.example.administrator.kaolafm50.discover.radio_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.radio_page.bean.ChannelInRadio;

import java.util.List;

/**
 * Created by Administrator on 16-5-23.
 */
public class RadioSelectChannel extends LinearLayout {

    private TextView radio_channel_tv1;
    private TextView radio_channel_tv2;
    private TextView radio_channel_tv3;
    private TextView radio_channel_tv4;

    public RadioSelectChannel(Context context, List<ChannelInRadio> list) {
        super(context);
        setPadding(30,0,30,0);
        inflate(context, R.layout.radio_select_channel_layout,this);
        radio_channel_tv1 = (TextView) findViewById(R.id.radio_channel_tv1);
        radio_channel_tv2 = (TextView) findViewById(R.id.radio_channel_tv2);
        radio_channel_tv3 = (TextView) findViewById(R.id.radio_channel_tv3);
        radio_channel_tv4 = (TextView) findViewById(R.id.radio_channel_tv4);
        setChannelTv(list);
    }

    private void setChannelTv(List<ChannelInRadio> list) {
        radio_channel_tv1.setText(list.get(0).getName());
        radio_channel_tv2.setText(list.get(1).getName());
        radio_channel_tv3.setText(list.get(2).getName());
        if (list.size()>3) {
            radio_channel_tv4.setText(list.get(3).getName());
        }else {
        }
    }

    public RadioSelectChannel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPadding(30,0,30,0);
        inflate(context, R.layout.radio_select_channel_layout,this);
        radio_channel_tv1 = (TextView) findViewById(R.id.radio_channel_tv1);
        radio_channel_tv2 = (TextView) findViewById(R.id.radio_channel_tv2);
        radio_channel_tv3 = (TextView) findViewById(R.id.radio_channel_tv3);
        radio_channel_tv4 = (TextView) findViewById(R.id.radio_channel_tv4);
    }
}
