package com.example.administrator.kaolafm50.others.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.example.administrator.kaolafm50.others.utils.ActivityJumpManager;

/**
 * 包含有一个标题和右侧播放按钮的父类activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ImageView ivBack,ivPlay;
    private TextView tvTitle;
    private LinearLayout llContent;
    private Special special;
    //可能是Special,也可能是其他内容
    private Parcelable playContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        ivBack= (ImageView) findViewById(R.id.base_title_back_iv);
        ivPlay= (ImageView) findViewById(R.id.base_titlebar_play_iv);
        tvTitle= (TextView) findViewById(R.id.base_titlebar_title_tv);
        llContent= (LinearLayout) findViewById(R.id.base_content_ll);

        //加载子类的布局
        LayoutInflater inflater = getLayoutInflater();
        View childView = inflater.inflate(getLayoutId(), null);

        //把子类的布局添加到
        llContent.addView(childView);

        ivBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ivPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //在这里根据页面内容传入不同类型对象给播放页面
                //注：暂时用Special举例
                ActivityJumpManager.jumpToPlay(BaseActivity.this,playContent);

            }
        });
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initEvent();
    protected abstract void initData();

    /**
     * 子类调用这个方法可以设置标题
     * @param title
     */
    protected void setTitle(String title){
        tvTitle.setText(title);
    }

    /**
     * 是否显示返回的箭头
     * @param isShow
     */
    protected void setShowBackBtn(boolean isShow){
        ivBack.setVisibility(isShow?View.VISIBLE: View.INVISIBLE);
    }

    protected void setPlayContent(Parcelable content){
        this.playContent=content;
    }
}
