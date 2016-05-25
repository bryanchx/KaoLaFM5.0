package com.example.administrator.kaolafm50.others.ui;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.bean.SpecialInLive;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.example.administrator.kaolafm50.others.utils.FileUtil;
import com.example.administrator.kaolafm50.others.utils.HttpUtil;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.example.administrator.kaolafm50.others.utils.KalaTask;
import com.example.administrator.kaolafm50.others.utils.LogUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class HomePlayerActivity extends Activity implements View.OnClickListener {

    private Special special;
    private SpecialInLive specialInLive;
    private MediaPlayer player = new MediaPlayer();
    private ImageButton player_home_ib_previous;
    private ImageButton player_home_ib_play;
    private ImageButton player_home_ib_next;
    private TextView player_home_tv_leftProgress;
    private TextView player_home_tv_rightProgress;
    private SeekBar player_home_sb_progress;
    int duration;
    int currentPosition;
    int per;
    private ImageView player_home_iv_upper_bg;
    private TextView player_home_tv_title;
    private TextView player_home_tv_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_player);

        player_home_ib_previous = (ImageButton) findViewById(R.id.player_home_ib_previous);
        player_home_ib_play = (ImageButton) findViewById(R.id.player_home_ib_play);
        player_home_ib_next = (ImageButton) findViewById(R.id.player_home_ib_next);
        player_home_tv_leftProgress = (TextView) findViewById(R.id.player_home_tv_leftProgress);
        player_home_tv_rightProgress = (TextView) findViewById(R.id.player_home_tv_rightProgress);
        player_home_sb_progress = (SeekBar) findViewById(R.id.player_home_sb_progress);
        //图片
        player_home_iv_upper_bg = (ImageView) findViewById(R.id.player_home_iv_upper_bg);
        //标题
        player_home_tv_title = (TextView) findViewById(R.id.player_home_tv_title);
        player_home_tv_msg = (TextView) findViewById(R.id.player_home_tv_msg);


        player_home_ib_previous.setOnClickListener(this);
        player_home_ib_play.setOnClickListener(this);
        player_home_ib_next.setOnClickListener(this);

//        String which = getIntent().getStringExtra("which");
        playRecommendMusic();
//        switch (which) {
//            case "recommend":
//                //播放从RecommendFragment跳转过来的音乐
//                break;
//            case "live":
//                //播放从RecommendFragment跳转过来的音乐
//                playliveMusic();
//                break;
//        }
    }

    private void playliveMusic() {
        specialInLive = getIntent().getParcelableExtra("specialInLive");
        //添加一个缓冲监听
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            private TimerTask timerTask;

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                duration = player.getDuration() / 1000;
                player_home_tv_title.setText(specialInLive.getRname());
                player_home_tv_msg.setText(specialInLive.getDes());
                ImageLoader.getInstance().displayImage(specialInLive.getPic(),  player_home_iv_upper_bg,
                        ImageUtil.getNormalImageOption());

                Timer timer = new Timer();
                timerTask = new TimerTask() {

                    @Override
                    public void run() {
                        if (player.isPlaying()) {
                            currentPosition = player.getCurrentPosition() / 1000;
                        }
                        LogUtil.w("getCurrentPosition=" + currentPosition);
                        per = currentPosition * 100 / duration;
                        player_home_sb_progress.setProgress(per);

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                player_home_tv_leftProgress.setText(currentPosition / 60 + ":" + currentPosition % 60);
                                player_home_tv_rightProgress.setText((duration - currentPosition) / 60 + ":" + (duration - currentPosition) % 60);

                            }
                        });
                    }
                };
                timer.schedule(timerTask, 0, 10);

//                LogUtil.w("duration="+duration);
            }
        });
        downLoadMp3(specialInLive.getMp3PlayUrl());

    }

    private void playRecommendMusic() {
        special = getIntent().getParcelableExtra("special");
        //添加一个缓冲监听
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            private TimerTask timerTask;

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                duration = player.getDuration() / 1000;
                player_home_tv_title.setText(special.getRname());
                player_home_tv_msg.setText(special.getDes());
                ImageLoader.getInstance().displayImage(special.getPic(),  player_home_iv_upper_bg,
                        ImageUtil.getNormalImageOption());

                Timer timer = new Timer();
                timerTask = new TimerTask() {

                    @Override
                    public void run() {
                        if (player.isPlaying()) {
                            currentPosition = player.getCurrentPosition() / 1000;
                        }
                        LogUtil.w("getCurrentPosition=" + currentPosition);
                        per = currentPosition * 100 / duration;
                        player_home_sb_progress.setProgress(per);

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                player_home_tv_leftProgress.setText(currentPosition / 60 + ":" + currentPosition % 60);
                                player_home_tv_rightProgress.setText((duration - currentPosition) / 60 + ":" + (duration - currentPosition) % 60);

                            }
                        });
                    }
                };
                timer.schedule(timerTask, 0, 10);

//                LogUtil.w("duration="+duration);
            }
        });
        downLoadMp3(special.getMp3PlayUrl());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    private void downLoadMp3(final String mp3PlayUrl) {
        if (mp3PlayUrl == null) {
            return;
        }
        final String rename = FileUtil.getFileName(mp3PlayUrl, null, true);
        final File mp3 = new File(FileUtil.AUDIO_DIR, rename);
        LogUtil.w("mp3路径：" + mp3.getAbsolutePath());
        if (mp3.exists()) {
            //直接播放
            playMp3(mp3.getAbsolutePath());
            return;
        }
        LogUtil.w("mp3路径：" + mp3.getAbsolutePath());
        new KalaTask(new KalaTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.downLoadFile(mp3PlayUrl, FileUtil.AUDIO_DIR, rename,
                        new KalaTask.IDownLoadListener() {

                            @Override
                            public void start() {

                            }

                            @Override
                            public void updateProgress(int progress) {

                            }

                            @Override
                            public void complete() {
                                String path = mp3.getAbsolutePath();
                                playMp3(path);
                            }

                            @Override
                            public void error() {

                            }
                        });
            }
        }, new KalaTask.IRequestCallback() {

            @Override
            public void success(Object obj) {

            }

            @Override
            public void error(String msg) {

            }
        }).execute();


    }

    /**
     * 播放音频
     */
    private void playMp3(String url) {
        player.reset();
        Uri uri = Uri.parse(url);

        try {
            player.setDataSource(this, uri);
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止播放，并释放资源
        player.stop();
        player.release();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.player_home_ib_play:
                if (!player.isPlaying()) {
                    player.start();
                    return;
                }
                player.pause();
                break;
        }
    }



}
