package com.example.administrator.kaolafm50.others.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.FileUtil;

import java.io.File;

public class CameraActivity extends AppCompatActivity {

    private ImageView camera_iv;
    private int code_thumb=1;
    private int code_source=2;
    private File imageFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        camera_iv = (ImageView) findViewById(R.id.camera_iv);

    }

    public void getThumb(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,code_thumb);
    }

    public void getResourse(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageFile=new File(FileUtil.IMAGE_DIR,"kalaCamera.png");
        Uri uri=Uri.fromFile(imageFile);
//        intent.setDataAndType(uri,MediaStore.EXTRA_OUTPUT);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        startActivityForResult(intent,code_source);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==code_thumb) {
            Bitmap bitmap = data.getParcelableExtra("data");
            camera_iv.setImageBitmap(bitmap);
        } else if (requestCode==code_source) {
            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inSampleSize=2;//缩放比例，值越大，图片越小
            Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
            camera_iv.setImageBitmap(bitmap);
        }
    }
}
