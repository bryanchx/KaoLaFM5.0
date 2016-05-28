package com.example.administrator.kaolafm50.others.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.ui.DiscoveryFragment;
import com.example.administrator.kaolafm50.discover.util.OtherUtil;
import com.example.administrator.kaolafm50.my.ui.MyFragment;
import com.example.administrator.kaolafm50.offline.OfflineFragment;
import com.example.administrator.kaolafm50.others.utils.KalaTask;
import com.example.administrator.kaolafm50.others.widget.KaoLaSlidePanelLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
    private Fragment[] fragments;
    private final String tag="fragmentTag";
    private RadioGroup home_rg;
    private FrameLayout home_content_fl;
    private FragmentManager fragmentManager ;
    private FragmentTransaction transaction;
    private int lastIndex;
    public KaoLaSlidePanelLayout home_spl;
//    private NavigationView home_nv;
    private LinearLayout home_nv;
    private LinearLayout home_content_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();

        checkUpdate();
        initView();
        initFragment();
        initEvents();
    }

    /**
     * 检查更新
     */
    private void checkUpdate() {
        OtherUtil.updateApk(new KalaTask.IRequestCallback() {

            @Override
            public void success(Object obj) {
                try {
                    JSONObject root = new JSONObject(obj.toString());
                    String message = root.getString("message");
                    if (message.equals("success")) {
                        JSONObject result = root.getJSONObject("result");
                        String updateVersion = result.getString("updateVersion");
                        PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void error(String msg) {

            }
        });
    }

    private void initView() {
        home_rg = (RadioGroup) findViewById(R.id.home_rg);
        home_content_fl = (FrameLayout) findViewById(R.id.home_content_fl);
        home_spl = (KaoLaSlidePanelLayout) findViewById(R.id.home_spl);
        home_nv = (LinearLayout) findViewById(R.id.home_nv);
        home_content_ll = (LinearLayout) findViewById(R.id.home_content_ll);
    }

    private void initEvents() {
        home_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = fragmentManager.beginTransaction();
                int index=0;
                switch (checkedId) {
                    case R.id.home_discovery_rb:
                        index=0;
                        break;
                    case R.id.home_my_rb:
                        index=1;
                        break;
                    case R.id.home_offline_rb:
                        index=2;
                        break;
                    default:
                        index=0;
                        break;
                }
                transaction.hide(fragments[lastIndex]);
                transaction.show(fragments[index]);
                transaction.commit();
                lastIndex=index;
            }
        });

        home_spl.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {

            @Override
            public void onPanelSlide(View panel, float slideOffset) {
//                LogUtil.w("slideOffset="+slideOffset);
                float scale= (float) (1-slideOffset*0.2);
                home_content_ll.setScaleX(scale);
                home_content_ll.setScaleY(scale);
            }

            @Override
            public void onPanelOpened(View panel) {
//                LogUtil.w("onPanelOpened=");

            }

            @Override
            public void onPanelClosed(View panel) {
//                LogUtil.w("onPanelClosed=");

            }
        });
//        home_nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.menu_setting_shake:
//                        Intent intent = new Intent(HomeActivity.this, ShakeActivity.class);
//                        startActivity(intent);
//                        break;
//                }
//                return false;
//            }
//        });
    }

    private void initFragment() {
        fragments=new Fragment[]{
                new DiscoveryFragment(),
                new MyFragment(),
                new OfflineFragment()
        };

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i=0;i<fragments.length;i++) {
            Fragment fragment = fragments[i];
            fragmentTransaction.add(R.id.home_content_fl,fragment,tag+i);
            fragmentTransaction.hide(fragment);
        }
        fragmentTransaction.show(fragments[0]);
        fragmentTransaction.commit();
    }

    //手势动作的第一个方法，分发
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
    //响应

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
