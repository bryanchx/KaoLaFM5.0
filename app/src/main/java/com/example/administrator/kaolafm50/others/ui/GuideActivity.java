package com.example.administrator.kaolafm50.others.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.adapter.CommFragmentPagerAdapter;
import com.example.administrator.kaolafm50.others.utils.ActivityJumpManager;
import com.example.administrator.kaolafm50.others.utils.Constants;
import com.example.administrator.kaolafm50.others.widget.IndexView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] videoIds=new int[]{
            R.raw.splash_1,
            R.raw.splash_2,
            R.raw.splash_4,
            R.raw.splash_5
    };
    private int[] leftImageId=new int[]{
            R.drawable.guide_anim_1_2,
            R.drawable.guide_anim_2_2,
            R.drawable.guide_anim_3_2,
            R.drawable.guide_anim_4_2
    };
    private int[] rightImageId=new int[]{
            R.drawable.guide_anim_1_1,
            R.drawable.guide_anim_2_1,
            R.drawable.guide_anim_3_1,
            R.drawable.guide_anim_4_1
    };
    private ViewPager guide_vp;
    private GuideVideoFragment lastFragment;
    List<Fragment> list=new ArrayList<>();
    private IndexView indexView;
    private Button guide_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
        indexView= (IndexView) findViewById(R.id.guide_index_view);
        guide_btn = (Button) findViewById(R.id.guide_btn);
        guide_btn.setOnClickListener(this);

        for (int i=0;i<4;i++) {
            GuideVideoFragment guideVideoFragment = new GuideVideoFragment(videoIds[i], leftImageId[i], rightImageId[i]);
            list.add(guideVideoFragment);
        }
        CommFragmentPagerAdapter guideVideoAdapter = new CommFragmentPagerAdapter(getSupportFragmentManager(), list);
        guide_vp.setAdapter(guideVideoAdapter);
        lastFragment= (GuideVideoFragment) list.get(0);
        guide_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                lastFragment.hindAnimImages();
                GuideVideoFragment fragment = (GuideVideoFragment) list.get(position);
                fragment.showAnimRight();
                lastFragment=fragment;
                indexView.changeIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.FLAG_FIRST_USED, MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(Constants.GETFLAG_FIRST_USED_TAG,false);
        editor.commit();
        ActivityJumpManager.jumpToHome(this);
        finish();
    }
}
