package com.example.administrator.kaolafm50.others.ui;


import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.administrator.kaolafm50.R;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class GuideVideoFragment extends BaseFragment {

    private int videoId;
    private int leftImageId;
    private int rightImageId;

    private VideoView videoView;
    private ImageView ivLeft,ivRight;

    public GuideVideoFragment(int videoId, int leftImageId, int rightVideoId) {
        this.videoId=videoId;
        this.leftImageId=leftImageId;
        this.rightImageId=rightVideoId;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_guide_video;
    }

    @Override
    protected void initView() {
        videoView= (VideoView) getView().findViewById(R.id.guide_video_vv);
        ivLeft= (ImageView) getView().findViewById(R.id.guide_video_left_iv);
        ivRight= (ImageView) getView().findViewById(R.id.guide_video_right_iv);

        ivLeft.setImageResource(leftImageId);
        ivRight.setImageResource(rightImageId);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        playVideo();
        showAnimRight();
    }

    public void showAnimRight() {
        ivLeft.setVisibility(View.INVISIBLE);
        ivRight.setVisibility(View.INVISIBLE);
        videoView.start();
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.guide_image_right);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivRight.setVisibility(View.VISIBLE);
                showAnimLeft();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivRight.startAnimation(animation);
    }

    private void showAnimLeft() {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.guide_image_left);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivLeft.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivLeft.startAnimation(animation);
    }

    private void playVideo() {
        Uri parse = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                +getActivity().getPackageName() + "/" + videoId);
        System.out.println("-----parse="+parse);
        videoView.setVideoURI(parse);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        videoView.start();
    }

    public void hindAnimImages(){
        ivLeft.setVisibility(View.GONE);
        ivRight.setVisibility(View.GONE);
        videoView.pause();
    }

}
