package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;

/**
 * Created by Administrator on 16-5-27.
 */
public class KaoLaLoadingLayout extends LoadingLayout {

    private AnimationDrawable drawable;

    public KaoLaLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
    }

    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.kaola_refresh;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

    }

    @Override
    protected void pullToRefreshImpl() {

    }

    @Override
    protected void refreshingImpl() {
        mHeaderImage.clearAnimation();
        mHeaderImage.setVisibility(VISIBLE);
        mHeaderProgress.setVisibility(INVISIBLE);
        drawable.start();
    }

    @Override
    protected void releaseToRefreshImpl() {

    }

    @Override
    protected void resetImpl() {

    }
}
