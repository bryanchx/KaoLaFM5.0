package com.example.administrator.kaolafm50.discover.util;

import com.example.administrator.kaolafm50.others.utils.HttpUtil;
import com.example.administrator.kaolafm50.others.utils.KalaTask;

/**
 * Created by Administrator on 16-5-19.
 */
public class DiscoverHttpUtil {

    //加载得到recommend中json的方法
    public static final String URL_RECOMMEND="http://api.kaolafm.com/api/v4/pagecontent/list?pageid=104&installid=10000&udid=03109aaa93c76cad9a0327e52eacc93a&imsi=460030238920982&operator=3&lon=113.945338&lat=22.534432&network=1&timestamp=1461832025&sign=3a9525cee60a25e487a099edbfcef6b1&resolution=1080*1812&devicetype=0&channel=A-360&version=4.7.1&appid=0\n";
    public static void getRecommend( KalaTask.IRequestCallback requestCallback){
        KalaTask.IRequest request = new KalaTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(URL_RECOMMEND);
            }
        };
        KalaTask task = new KalaTask(request,requestCallback);
        task.execute();
    }

    //加载得到live中json的方法
    public static final String URL_LIVE="http://api.kaolafm.com/api/v4/pagecontent/list?pageid=106&timezone=28800&installid=10000&udid=4a0dad0a10c011ced7fe02269b2cc5e3&sessionid=4a0dad0a10c011ced7fe02269b2cc5e31463826991553&imsi=460026027461772&operator=1&lon=113.945078&lat=22.53441&network=1&timestamp=1463826997&sign=bd270ebbc8b4bfe1079d5e811461f809&resolution=1080*1794&devicetype=0&channel=upgrade&version=4.8.1&appid=0&";
    public static void getLive( KalaTask.IRequestCallback requestCallback){
        KalaTask.IRequest request = new KalaTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(URL_LIVE);
            }
        };
        KalaTask task = new KalaTask(request,requestCallback);
        task.execute();
    }
    //加载得到anchor中json的方法
    public static final String URL_ANCHOR="http://api.kaolafm.com/api/v4/pagecontent/list?pageid=105&timezone=28800&installid=10000&udid=4a0dad0a10c011ced7fe02269b2cc5e3&sessionid=4a0dad0a10c011ced7fe02269b2cc5e31463972985527&imsi=460026027461772&operator=1&lon=113.945039&lat=22.534676&network=1&timestamp=1463972996&sign=bd270ebbc8b4bfe1079d5e811461f809&resolution=1080*1794&devicetype=0&channel=upgrade&version=4.8.1&appid=0&";
    public static void getAnchor( KalaTask.IRequestCallback requestCallback){
        KalaTask.IRequest request = new KalaTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(URL_ANCHOR);
            }
        };
        KalaTask task = new KalaTask(request,requestCallback);
        task.execute();
    }
    //加载得到radio中json的方法
    public static final String URL_RADIO="http://api.kaolafm.com/api/v4/pagecontent/list?pageid=107&timezone=28800&installid=10000&udid=4a0dad0a10c011ced7fe02269b2cc5e3&sessionid=4a0dad0a10c011ced7fe02269b2cc5e31463996306303&imsi=460026027461772&operator=1&lon=113.945105&lat=22.534596&network=1&timestamp=1463996347&sign=bd270ebbc8b4bfe1079d5e811461f809&resolution=1080*1794&devicetype=0&channel=upgrade&version=4.8.1&appid=0&";
    public static void getRadio( KalaTask.IRequestCallback requestCallback){
        KalaTask.IRequest request = new KalaTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(URL_RADIO);
            }
        };
        KalaTask task = new KalaTask(request,requestCallback);
        task.execute();
    }
    //加载得到type中json的方法
    public static final String URL_TYPE="http://api.kaolafm.com/api/v4/category/listofall?timezone=28800&installid=10000&udid=4a0dad0a10c011ced7fe02269b2cc5e3&sessionid=4a0dad0a10c011ced7fe02269b2cc5e31464078476059&imsi=460026027461772&operator=1&lon=0.0&lat=0.0&network=1&timestamp=1464078498&sign=bd270ebbc8b4bfe1079d5e811461f809&resolution=1080*1794&devicetype=0&channel=upgrade&version=4.8.1&appid=0&";
    public static void getType( KalaTask.IRequestCallback requestCallback){
        KalaTask.IRequest request = new KalaTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(URL_TYPE);
            }
        };
        KalaTask task = new KalaTask(request,requestCallback);
        task.execute();
    }
}
