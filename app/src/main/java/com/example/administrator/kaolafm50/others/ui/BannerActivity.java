package com.example.administrator.kaolafm50.others.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.ActivityJumpManager;
import com.example.administrator.kaolafm50.others.utils.KalaTask;
import com.example.administrator.kaolafm50.others.utils.LogUtil;
import com.example.administrator.kaolafm50.others.utils.OKHttpUtil;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        imageView.setLayoutParams(layoutParams);
        setContentView(imageView);

        String url = "http://api.kaolafm.com/api/v4/splashscreen/list?timezone=28800&installid=10000&udid=4a0dad0a10c011ced7fe02269b2cc5e3&sessionid=4a0dad0a10c011ced7fe02269b2cc5e31464243407711&imsi=460026027461772&operator=1&lon=0.0&lat=0.0&network=1&timestamp=1464243407&sign=bd270ebbc8b4bfe1079d5e811461f809&resolution=1080*1794&devicetype=0&channel=upgrade&version=4.8.1&appid=0&";
        OKHttpUtil.getJson(url, new KalaTask.IRequestCallback() {

            @Override
            public void success(Object obj) {
                JSONObject root = null;
                try {
                    root = new JSONObject(obj.toString());
                    String message = root.getString("message");

                    if ("success".equals(message)) {
                        JSONObject result = root.getJSONObject("result");
                        final String img = result.getString("img");
                        LogUtil.w("img=" + img);

                        Picasso.with(BannerActivity.this)
                                .load(img)
                                .placeholder(R.drawable.album_hidden)//占位图片
//                                        .transform(new CircleTransform(false))
                                .error(R.drawable.no_send)//加载失败显示的图片
                                .into(imageView);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void error(String msg) {

            }
        });

        //3秒后跳转到主页
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ActivityJumpManager.jumpToHome(BannerActivity.this);
                        finish();
                    }
                });

            }
        }).start();

    }

    //屏蔽返回键
    @Override
    public void onBackPressed() {

    }
}
