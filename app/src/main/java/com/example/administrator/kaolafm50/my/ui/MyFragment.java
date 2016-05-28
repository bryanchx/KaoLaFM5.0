package com.example.administrator.kaolafm50.my.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.my.adapter.MyViewPagerAdapter;
import com.example.administrator.kaolafm50.my.widget.KaoLaScrollView;
import com.example.administrator.kaolafm50.others.ui.BaseFragment;
import com.example.administrator.kaolafm50.others.utils.FileUtil;
import com.example.administrator.kaolafm50.others.utils.LogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyFragment extends BaseFragment implements View.OnClickListener{

    private RelativeLayout my_rl_upper;
    private TabLayout my_tl;
    private ViewPager my_vp;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();
    private KaoLaScrollView my_klsv;

    private int code=1;
    private ImageView my_iv_camera;

    private File imageFile;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        my_rl_upper= (RelativeLayout) root.findViewById(R.id.my_rl_upper);
        my_tl = (TabLayout) root.findViewById(R.id.my_tl);
        my_vp = (ViewPager) root.findViewById(R.id.my_vp);
        my_klsv = (KaoLaScrollView) root.findViewById(R.id.my_klsv);

        my_iv_camera = (ImageView) root.findViewById(R.id.my_iv_camera);
        my_iv_camera.setOnClickListener(this);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        fragments.add(new ListenhistoryFragment());
        fragments.add(new SubscribeFragment());
        fragments.add(new ConnectionFragment());

        titles.add("收听历史");
        titles.add("订阅");
        titles.add("收藏");
        my_tl.setTabMode(TabLayout.MODE_FIXED);
        my_tl.addTab(my_tl.newTab().setText(titles.get(0)));
        my_tl.addTab(my_tl.newTab().setText(titles.get(1)));
        my_tl.addTab(my_tl.newTab().setText(titles.get(2)));

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments,titles);
        my_vp.setAdapter(myViewPagerAdapter);
        my_vp.setCurrentItem(0);
        my_tl.setupWithViewPager(my_vp);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            my_klsv.setOnScrollChangeListener(new View.OnScrollChangeListener() {

                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    LogUtil.w("scrollX="+scrollX+" scrollY="+scrollY+" oldScrollX="+oldScrollX+" oldScrollY="+oldScrollY);
                }
            });
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1) {
            BitmapFactory.Options options=new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
            my_iv_camera.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        imageFile=new File(FileUtil.IMAGE_DIR,"kalaTouxiang.png");
        Uri uri=Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        startActivityForResult(intent,code);
    }
}
