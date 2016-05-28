package com.example.administrator.kaolafm50.others.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.math.BigDecimal;

/**
 * Created by Administrator on 16-5-28.
 */
public class KaoLaSensorListener implements SensorEventListener {

    //传感器对象
    private Sensor sensor;
    //传感器服务
    private SensorManager manager;

    private long lastUpdateTime;
    //更新的时间间隔
    private long updateTag=200;

    private float speedTag=100;

    private float lastX,lastY,lastZ;

    private IShakeListener iShakeListener;

    public KaoLaSensorListener(Context context) {
        //获取传感器服务
        manager= (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        //获取一个默认的传感器对象
        sensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //注册到系统服务里面，相当于启动了一个服务
        manager.registerListener(this,sensor,Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
//        LogUtil.w("onSensorChanged");

        long currentTime = System.currentTimeMillis();
        if (currentTime-lastUpdateTime<200) {
            return;
        }

        lastUpdateTime=currentTime;
        float[] values = event.values;
        float x=values[0];
        float y=values[1];
        float z=values[2];

        //计算三个空间坐标值的相对位移
        float distantsX=x-lastX;
        float distantsY=x-lastY;
        float distantsZ=x-lastZ;

        float distants= (float) Math.sqrt(distantsX*distantsX+distantsY*distantsY+distantsZ*distantsZ);
        //计算每秒钟摇动的速度
        float speed = distants * 1000 / updateTag;

        //取这个速度的两位小数，四舍五入
        BigDecimal bigDecimal = new BigDecimal(speed).setScale(2, BigDecimal.ROUND_HALF_UP);
        speed=bigDecimal.floatValue();

        if (speed>speedTag&&iShakeListener!=null) {
            LogUtil.w("speed="+speed);
            iShakeListener.onShake(speed);
        }
        //记录上一次的空间坐标
        lastX=x;
        lastY=y;
        lastZ=z;

//        LogUtil.w("x="+x+"  y="+y+"  z="+z);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void setIShakeListener(IShakeListener iShakeListener){
        this.iShakeListener=iShakeListener;
    }

    //摇一摇接口
    public interface IShakeListener{

        /**
         * @param speed 正在摇动速度
         */
        void onShake(float speed);
    }

    public void unRegister(){
        manager.unregisterListener(this);
    }
}
