package com.example.administrator.kaolafm50.discover.live_page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.bean.SpecialInLive;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by ASUS on 2016/5/22.
 */
public class LivingItem1 extends RelativeLayout{

    private ImageView widget_living_item1_content_iv;
    private TextView widget_living_item1_programLikedNum_tv;
    private TextView widget_living_item1_name_tv;
    private TextView widget_living_item1_comperes_tv;

    public LivingItem1(Context context) {
        super(context);
        inflate(context, R.layout.widget_living_item1,this);
        widget_living_item1_content_iv = (ImageView) findViewById(R.id.widget_living_item1_content_iv);
        widget_living_item1_programLikedNum_tv = (TextView) findViewById(R.id.widget_living_item1_programLikedNum_tv);
        widget_living_item1_name_tv = (TextView) findViewById(R.id.widget_living_item1_name_tv);
        widget_living_item1_comperes_tv = (TextView) findViewById(R.id.widget_living_item1_comperes_tv);

    }

    public LivingItem1(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_living_item1,this);
        widget_living_item1_content_iv = (ImageView) findViewById(R.id.widget_living_item1_content_iv);
        widget_living_item1_programLikedNum_tv = (TextView) findViewById(R.id.widget_living_item1_programLikedNum_tv);
        widget_living_item1_name_tv = (TextView) findViewById(R.id.widget_living_item1_name_tv);
        widget_living_item1_comperes_tv = (TextView) findViewById(R.id.widget_living_item1_comperes_tv);

    }

    public void setLivingItem1(SpecialInLive specialInLive){
        ImageLoader.getInstance().displayImage(specialInLive.getProgramPic(),widget_living_item1_content_iv,
                ImageUtil.getNormalImageOption());
        widget_living_item1_programLikedNum_tv.setText(specialInLive.getProgramLikedNum()+"");
        String programName="回听"+specialInLive.getProgramName();
        widget_living_item1_name_tv.setText(programName);
        widget_living_item1_comperes_tv.setText(specialInLive.getComperes());
    }
}
