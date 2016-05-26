package com.example.administrator.kaolafm50.others.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 16-5-26.
 */
public class OKHttpUtil {
    enum RequestType{
        GET,
        POST
    }
    private static OkHttpClient client;
    private static OkHttpClient getOkHttpClientInstance(){
        if (client==null) {
            synchronized (OKHttpUtil.class){
                if (client==null) {
                    client=new OkHttpClient();
                }
            }
        }
        return client;
    }
    public static void doGet(String url,final KalaTask.IRequestCallback callback){
        //创建一个请求客户端
        getOkHttpClientInstance();

        Request request=new Request.Builder()
                .url(url)//请求地址
                .get()//bbbbget请求
                .build();//创建request
        //相当于本工程的KaoLaTask
        Call call=client.newCall(request);
//        try {
//            Response response = call.execute();//创建一个子线程直接执行
//            if (response!=null&&callback!=null) {
//                callback.success(response);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                if (callback!=null) {
                    callback.error(e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                body.byteStream();
                body.charStream();
                if (callback!=null) {
                    callback.success(response);
                }
            }
        });
    }
    public static void getJson(final String url, final KalaTask.IRequestCallback callback){
        LogUtil.w("url="+url);
        //创建一个请求客户端
        getOkHttpClientInstance();

        Request request=new Request.Builder()
                .url(url)//请求地址
                .get()//get请求
                .build();//创建request
        //相当于本工程的KaoLaTask
        Call call=client.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(e.getMessage());
                if (callback!=null) {
                    callback.error(e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                body.byteStream();
                Reader reader = body.charStream();
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line=null;
                StringBuffer resultBuffer = new StringBuffer();
                while ((line=bufferedReader.readLine())!=null) {
                    resultBuffer.append(line);
                }
                String result = resultBuffer.toString();
                LogUtil.w("result="+result);
                if (callback!=null) {
                    callback.success(response);
                }
                reader.close();
                bufferedReader.close();
            }
        });
    }
    public static void downLoad(String url, final File dir, final String rename, final KalaTask.IDownLoadListener listener){
        getOkHttpClientInstance();
         Request request=new Request.Builder()
                 .url(url)
                 .get()
                 .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e("请求失败了："+e.getMessage());
                if (listener!=null) {
                    listener.error();
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                InputStream inputStream = body.byteStream();
                int read=-1;
                int hasRead=0;
                byte[] bytes = new byte[1024];
                //文件的大小
                long length = body.contentLength();
                //目标文件
                File target=new File(dir,rename);
                //创建输出流
                FileOutputStream fos = new FileOutputStream(target);
                if (listener!=null) {
                    listener.start();
                }
                //循环读取
                while ((read=inputStream.read(bytes))!=-1) {
                    //写到文件里
                    fos.write(bytes,0,read);
                    //计算下载进度
                    hasRead+=read;
                    float per=100.0f*hasRead/length;
                    LogUtil.w("per="+per);
                    if (listener!=null) {
                        listener.updateProgress((int) per);
                    }
                }
                if (listener!=null) {
                    listener.complete();
                }
                inputStream.close();
                fos.flush();
                fos.close();
            }
        });

    }
}
