package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 主播控件
 */
public class AnchorItem extends LinearLayout{

    private ImageView imageView;
    private TextView tvName,tvNum;
    public AnchorItem(Context context, Special special) {
        super(context);
        inflate(context, R.layout.widget_anchor_item,this);
        imageView= (ImageView) findViewById(R.id.anchor_item_iv);
        tvName= (TextView) findViewById(R.id.anchor_item_name_tv1);
        tvNum= (TextView) findViewById(R.id.anchor_item_num_tv2);
        setSpecial(special);
    }

    public AnchorItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_anchor_item,this);
        imageView= (ImageView) findViewById(R.id.anchor_item_iv);
        tvName= (TextView) findViewById(R.id.anchor_item_name_tv1);
        tvNum= (TextView) findViewById(R.id.anchor_item_num_tv2);
    }

    public void setSpecial(Special special) {
        ImageLoader.getInstance().displayImage(special.getAvatar(),imageView, ImageUtil.getCircleImageOption());
        tvName.setText(special.getNickName());
        tvNum.setText(special.getLikedNum()+"");

        //设置表示性别标识
        int gender = special.getGender();
        Drawable drawable=null;
        if (gender==0) {
            drawable=getResources().getDrawable(R.drawable.man);
        } else if (gender==1) {
            drawable=getResources().getDrawable(R.drawable.woman);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tvName.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null, drawable,null);
        }
    }
}
