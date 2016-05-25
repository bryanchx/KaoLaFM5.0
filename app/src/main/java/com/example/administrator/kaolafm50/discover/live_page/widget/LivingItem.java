package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.bean.SpecialInLive;
import com.example.administrator.kaolafm50.others.utils.ActivityJumpManager;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 16-5-22.
 */
public class LivingItem extends RelativeLayout{

    private ImageView live_iv_pic;
    private ImageView live_iv_living;
    private TextView live_tv_programName;
    private ImageView live_iv_pic_small;
    private TextView live_tv_comperes;
    private ImageView live_iv_online;
    private TextView live_tv_onLineNum;
    private ImageView live_iv_like;
    private TextView live_tv_like;
    private SpecialInLive specialInLive;
    public LivingItem(Context context,SpecialInLive specialInLive) {
        super(context);
        this.specialInLive=specialInLive;
        setPadding(30,0,30,0);
        inflate(context, R.layout.widget_living_item,this);
        live_iv_pic = (ImageView) findViewById(R.id.live_iv_pic);
        live_iv_living = (ImageView) findViewById(R.id.live_iv_living);
        live_tv_programName = (TextView) findViewById(R.id.live_tv_programName);
        live_iv_pic_small = (ImageView) findViewById(R.id.live_iv_pic_small);
        live_tv_comperes = (TextView) findViewById(R.id.live_tv_comperes);
        live_iv_online = (ImageView) findViewById(R.id.live_iv_online);
        live_tv_onLineNum = (TextView) findViewById(R.id.live_tv_onLineNum);
        live_iv_like = (ImageView) findViewById(R.id.live_iv_like);
        live_tv_like = (TextView) findViewById(R.id.live_tv_like);
        setLivingItem(specialInLive);
    }

    public LivingItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_living_item,this);
        live_iv_pic = (ImageView) findViewById(R.id.live_iv_pic);
        live_iv_living = (ImageView) findViewById(R.id.live_iv_living);
        live_tv_programName = (TextView) findViewById(R.id.live_tv_programName);
        live_iv_pic_small = (ImageView) findViewById(R.id.live_iv_pic_small);
        live_tv_comperes = (TextView) findViewById(R.id.live_tv_comperes);
        live_iv_online = (ImageView) findViewById(R.id.live_iv_online);
        live_tv_onLineNum = (TextView) findViewById(R.id.live_tv_onLineNum);
        live_iv_like = (ImageView) findViewById(R.id.live_iv_like);
        live_tv_like = (TextView) findViewById(R.id.live_tv_like);
    }

    public void setLivingItem(final SpecialInLive specialInLive){
        ImageLoader.getInstance().displayImage(specialInLive.getProgramPic(),live_iv_pic, ImageUtil.getNormalImageOption());
        ImageLoader.getInstance().displayImage(specialInLive.getProgramPic(),live_iv_pic_small, ImageUtil.getCircleImageOption());
        live_tv_programName.setText(specialInLive.getProgramName());
        live_tv_comperes.setText(specialInLive.getComperes());
        live_tv_onLineNum.setText(specialInLive.getOnLineNum()+"");
        live_tv_like.setText(specialInLive.getProgramLikedNum()+"");
        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivityJumpManager.jumpToPlay((Activity) getContext(),specialInLive);
            }
        });
    }
}
