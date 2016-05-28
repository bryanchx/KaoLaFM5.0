package com.example.administrator.kaolafm50.others.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.Intents;

public class ZxingActivity extends AppCompatActivity {

    private TextView zxing_tv;
    private EditText zxing_et;

    private int code_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        zxing_tv = (TextView) findViewById(R.id.zxing_tv);
        zxing_et = (EditText) findViewById(R.id.zxing_et);


    }

    public void toScan(View view){
        //跳转到扫一扫
        Intent intent = new Intent(Intents.Scan.ACTION);
        //设置扫描二维码模式
        intent.putExtra(Intents.Scan.MODE,Intents.Scan.QR_CODE_MODE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;

        int size=width>height?height:width;

        size=size/2;

        intent.putExtra(Intents.Scan.WIDTH,size);
        intent.putExtra(Intents.Scan.HEIGHT,size);

        startActivityForResult(intent,code_scan);

    }
    public void toCreat(View view){
        Intent intent = new Intent(Intents.Encode.ACTION);
        //生成的图片类型为二维码
        intent.putExtra(Intents.Encode.FORMAT, BarcodeFormat.QR_CODE);
        //把文本类型生成二维码
        intent.putExtra(Intents.Encode.TYPE, Contents.Type.TEXT);
        //指定内容源
        intent.putExtra(Intents.Encode.DATA,zxing_et.getText().toString().trim());
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==code_scan) {
            String result = data.getStringExtra(Intents.Scan.RESULT);
            zxing_tv.setText(result);
        }

    }
}
