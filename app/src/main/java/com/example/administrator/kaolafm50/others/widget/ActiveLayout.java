package com.example.administrator.kaolafm50.others.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Recommend;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 16-5-20.
 */
public class ActiveLayout extends LinearLayout{

    private TextView tv1,tv2,tv3;
    private ImageView iv1,iv2,iv3;
    public ActiveLayout(Context context,Recommend recommend) {
        super(context);
        inflate(context, R.layout.widget_active,this);
        tv1= (TextView) findViewById(R.id.widget_active_tv1);
        tv2= (TextView) findViewById(R.id.widget_active_tv2);
        tv3= (TextView) findViewById(R.id.widget_active_tv3);
        iv1= (ImageView) findViewById(R.id.widget_active_iv1);
        iv2= (ImageView) findViewById(R.id.widget_active_iv2);
        iv3= (ImageView) findViewById(R.id.widget_active_iv3);

        setRecommend(recommend);
    }

    public ActiveLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setRecommend(Recommend recommend){
        tv1.setText(recommend.getDataList().get(0).getRname());
        tv2.setText(recommend.getDataList().get(1).getRname());
        tv3.setText(recommend.getDataList().get(2).getRname());

        ImageLoader.getInstance().displayImage(recommend.getDataList().get(0).getPic(),iv1, ImageUtil.getNormalImageOption());
        ImageLoader.getInstance().displayImage(recommend.getDataList().get(1).getPic(),iv2, ImageUtil.getNormalImageOption());
        ImageLoader.getInstance().displayImage(recommend.getDataList().get(2).getPic(),iv3, ImageUtil.getNormalImageOption());

    }

}
