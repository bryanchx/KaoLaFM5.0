package com.example.administrator.kaolafm50.others.utils;

import android.view.MotionEvent;

/**
 * Created by Administrator on 16-5-25.
 */
public class EventUtil {
    public static String parseEvent(MotionEvent event){
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            case MotionEvent.ACTION_HOVER_MOVE:
                return "ACTION_HOVER_MOVE";

        }
        return null;
    }
}
