package com.example.administrator.kaolafm50.discover.anchor_page.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.anchor_page.bean.SpecialInAnchor;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 主播控件
 */
public class AnchorAnchorItem1 extends LinearLayout{

    private ImageView imageView;
    private TextView tvName,tvNum;
    public AnchorAnchorItem1(Context context, SpecialInAnchor specialInAnchor) {
        super(context);
        inflate(context, R.layout.widget_anchor_anchor_item1,this);
        imageView= (ImageView) findViewById(R.id.anchor_anchor_item_iv);
        tvName= (TextView) findViewById(R.id.anchor_anchor_item_name_tv1);
        tvNum= (TextView) findViewById(R.id.anchor_anchor_item_num_tv2);
        setSpecial1(specialInAnchor);
    }

    public AnchorAnchorItem1(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_anchor_anchor_item1,this);
        imageView= (ImageView) findViewById(R.id.anchor_anchor_item_iv);
        tvName= (TextView) findViewById(R.id.anchor_anchor_item_name_tv1);
        tvNum= (TextView) findViewById(R.id.anchor_anchor_item_num_tv2);
    }

    public void setSpecial1(SpecialInAnchor specialInAnchor) {
        ImageLoader.getInstance().displayImage(specialInAnchor.getAvatar(),imageView, ImageUtil.getCircleImageOption());
        tvName.setText(specialInAnchor.getNickName());
        tvNum.setText(specialInAnchor.getLikedNum()+"");

        //设置表示性别标识
        int gender = specialInAnchor.getGender();
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
