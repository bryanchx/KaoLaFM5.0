package com.example.administrator.kaolafm50.others.utils;

import android.os.Handler;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


/**
 * Created by Administrator on 16-5-26.
 */
public class OKHttpUtil {
    //广告页的URL地址
    public static String URL_BANNER= "http://api.kaolafm.com/api/v4/splashscreen/list?timezone=28800&installid=10000&udid=4a0dad0a10c011ced7fe02269b2cc5e3&sessionid=4a0dad0a10c011ced7fe02269b2cc5e31464243407711&imsi=460026027461772&operator=1&lon=0.0&lat=0.0&network=1&timestamp=1464243407&sign=bd270ebbc8b4bfe1079d5e811461f809&resolution=1080*1794&devicetype=0&channel=upgrade&version=4.8.1&appid=0&";

    private static Handler handler=new Handler();
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
            public void onFailure(Request request, final IOException e) {
                if (callback!=null) {
                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            callback.error(e.getMessage());

                        }
                    });
                }
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                ResponseBody body = response.body();
                body.byteStream();
                body.charStream();
                if (callback!=null) {
                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            callback.success(response);

                        }
                    });

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
            public void onFailure(Request request, final IOException e) {
                LogUtil.e(e.getMessage());
                if (callback!=null) {
                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            callback.error(e.getMessage());

                        }
                    });
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseBody body = response.body();
                body.byteStream();
                Reader reader = body.charStream();
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line=null;
                StringBuffer resultBuffer = new StringBuffer();
                while ((line=bufferedReader.readLine())!=null) {
                    resultBuffer.append(line);
                }
                final String result = resultBuffer.toString();
                LogUtil.w("result="+result);
                if (callback!=null) {
                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            callback.success(result);

                        }
                    });
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
            public void onFailure(Request request, IOException e) {
                LogUtil.e("请求失败了："+e.getMessage());
                if (listener!=null) {
                    listener.error();
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {
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
