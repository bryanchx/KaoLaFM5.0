package com.example.administrator.kaolafm50.others.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.administrator.kaolafm50.discover.live_page.bean.SpecialInLive;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.example.administrator.kaolafm50.others.ui.BannerActivity;
import com.example.administrator.kaolafm50.others.ui.GuideActivity;
import com.example.administrator.kaolafm50.others.ui.HomeActivity;
import com.example.administrator.kaolafm50.others.ui.HomePlayerActivity;
import com.example.administrator.kaolafm50.others.ui.WebActivity;

/**
 * Created by Administrator on 16-5-18.
 */
public class ActivityJumpManager {
    public static void jumpToHome(Activity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }
    public static void jumpToHomePlayer(Activity activity){
        Intent intent = new Intent(activity, HomePlayerActivity.class);
        activity.startActivity(intent);
    }
    public static void jumpToGuide(Activity activity){
        Intent intent = new Intent(activity, GuideActivity.class);
        activity.startActivity(intent);
    }
    public static void jumpToBanner(Activity activity){
        Intent intent = new Intent(activity, BannerActivity.class);
        activity.startActivity(intent);
    }

    public static void jumpToPlay(Activity activity, Special special){
        Intent intent=new Intent(activity,HomePlayerActivity.class);
        intent.putExtra("special",special);
        intent.putExtra("which","recommend");
        activity.startActivity(intent);

    }
    public static void jumpToPlay(Activity activity, SpecialInLive specialInLive){
        Intent intent=new Intent(activity,HomePlayerActivity.class);
        intent.putExtra("specialInLive",specialInLive);
        intent.putExtra("which","live");
        activity.startActivity(intent);

    }

    /**
     * 跳转到浏览器界面
     * @param activity
     * @param special
     */
    public static void jumpToWeb(Activity activity, Special special){
        Intent intent=new Intent(activity,WebActivity.class);
        intent.putExtra("special",special);
        intent.putExtra("which","recommend");
        activity.startActivity(intent);

    }
}
