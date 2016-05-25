package com.example.administrator.kaolafm50.others.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 16-5-19.
 */
public class HttpUtil {

    private static String key;

    public static Object doGet(String httpUrl){
        InputStream inputStream=null;
        BufferedReader reader=null;
        InputStreamReader streamReader=null;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
            hcon.setRequestMethod("GET");
            hcon.setConnectTimeout(5000);
            hcon.setReadTimeout(5000);
            hcon.connect();
            int code = hcon.getResponseCode();
            if (code==HttpURLConnection.HTTP_OK) {
                inputStream=hcon.getInputStream();
                streamReader = new InputStreamReader(inputStream);
                reader=new BufferedReader(streamReader);
                StringBuffer buffer=new StringBuffer();
                String line=null;
                while ((line=reader.readLine())!=null) {
                    buffer.append(line);
                }
                String result=buffer.toString();
                LogUtil.w("HttpUtil:"+result);
                return result;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null) {
                try {
                    inputStream.close();
                    streamReader.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        LogUtil.w("请求失败！");
        return null;
    }

    public static Object doPost(String httpUrl, HashMap<String,String> params){
        Set<Map.Entry<String, String>> set = params.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        StringBuffer paramsBuffer=new StringBuffer();
        if (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            key = entry.getKey();
            paramsBuffer.append(key);
            paramsBuffer.append("=");
            String value=entry.getValue();
            paramsBuffer.append(value);
            paramsBuffer.append("&");
        }
        String paramString = paramsBuffer.toString();
        paramString=paramString.substring(0,paramString.length()-1);

        InputStream inputStream=null;
        BufferedReader reader=null;
        InputStreamReader streamReader=null;
        OutputStream outputStream=null;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
            hcon.setRequestMethod("POST");
            hcon.setConnectTimeout(5000);
            hcon.setReadTimeout(5000);
            hcon.setUseCaches(true);
            hcon.setDoOutput(true);
            hcon.connect();
            outputStream = hcon.getOutputStream();
            outputStream.write(paramString.getBytes());
            outputStream.flush();
            int code = hcon.getResponseCode();
            if (code==HttpURLConnection.HTTP_OK) {
                inputStream=hcon.getInputStream();
                streamReader = new InputStreamReader(inputStream);
                reader=new BufferedReader(streamReader);
                StringBuffer buffer=new StringBuffer();
                String line=null;
                while ((line=reader.readLine())!=null) {
                    buffer.append(line);
                }
                String result=buffer.toString();
                LogUtil.w("HttpUtil:"+result);
                return result;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null) {
                try {
                    inputStream.close();
                    streamReader.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        LogUtil.w("请求失败！");
        return null;
    }

    public static File downLoadFile(String httpUrl,File dir,String fileName,KalaTask.IDownLoadListener listener){
        LogUtil.w("httpUrl="+httpUrl);
        InputStream inputStream=null;
        FileOutputStream fos=null;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
            hcon.setRequestMethod("GET");
            hcon.setConnectTimeout(5000);
            hcon.setReadTimeout(5000);
            hcon.connect();
            if (hcon.getResponseCode()==HttpURLConnection.HTTP_OK) {
                inputStream=hcon.getInputStream();
                byte[] bytes=new byte[1024];
                int r=-1;
                File targetFile=new File(dir,fileName);
                fos=new FileOutputStream(targetFile);
                if (listener!=null) {
                    listener.start();
                }
                int contentLength = hcon.getContentLength();
                int hasRead=0;
                int progress=0;
                while ((r=inputStream.read(bytes))!=-1) {
                    fos.write(bytes,0,r);
                    hasRead+=r;
                    int per = (int) (hasRead * 100.0 / contentLength);
                    LogUtil.w(per+"");
                    if (listener!=null) {
                        listener.updateProgress(per);
                    }
                }
                fos.flush();
                LogUtil.w("下载成功！");
                if (listener!=null) {
                    listener.complete();
                }
                return targetFile;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        LogUtil.w("请求失败！");
        if (listener!=null) {
            listener.error();
        }
        return null;
    }

}
