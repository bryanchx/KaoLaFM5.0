package com.example.administrator.kaolafm50.others.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.example.administrator.kaolafm50.others.utils.ActivityJumpManager;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 16-5-19.
 */
public class SpecialItem extends RelativeLayout{


    private ImageView widget_special_item_content_iv;
    private ImageView widget_special_item_play_iv;
    private TextView widget_special_item_name_tv;
    private TextView special_item_des_tv;

    public SpecialItem(Context context) {
        super(context);
        //把当前布局作为此控件的视图
        inflate(context, R.layout.widget_special_item,this);
        widget_special_item_content_iv = (ImageView) findViewById(R.id.widget_special_item_content_iv);
        widget_special_item_play_iv = (ImageView) findViewById(R.id.widget_special_item_play_iv);
        widget_special_item_name_tv = (TextView) findViewById(R.id.widget_special_item_name_tv);
        special_item_des_tv = (TextView) findViewById(R.id.special_item_des_tv);
    }

    public SpecialItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        //把当前布局作为此控件的视图
        inflate(context, R.layout.widget_special_item,this);
        widget_special_item_content_iv = (ImageView) findViewById(R.id.widget_special_item_content_iv);
        widget_special_item_play_iv = (ImageView) findViewById(R.id.widget_special_item_play_iv);
        widget_special_item_name_tv = (TextView) findViewById(R.id.widget_special_item_name_tv);
        special_item_des_tv = (TextView) findViewById(R.id.special_item_des_tv);
    }

    public void setSpecial(final Special special){
        widget_special_item_name_tv.setText(special.getRname());
        special_item_des_tv.setText(special.getDes());

        ImageLoader.getInstance().displayImage(special.getPic(),widget_special_item_content_iv,
                ImageUtil.getNormalImageOption());

        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
//                ActivityJumpManager.jumpToPlay((Activity) getContext(),special);
                ActivityJumpManager.jumpToWeb((Activity) getContext(),special);
            }
        });
    }


    public void setOnitemclickListener(OnClickListener listener){
        this.setOnClickListener(listener);
    }
}
