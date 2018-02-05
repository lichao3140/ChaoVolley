package com.lichao.chaovolley.http;

import com.alibaba.fastjson.JSON;
import com.lichao.chaovolley.http.interfaces.IHttpListener;
import com.lichao.chaovolley.http.interfaces.IHttpService;
import com.lichao.chaovolley.http.interfaces.RequestHolder;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2018-02-01.
 */

public class HttpTask<T> implements Runnable {
    private IHttpService httpService;
    private FutureTask futureTask;

    public HttpTask(RequestHolder<T> requestHolder) {
        httpService = requestHolder.getHttpService();
        httpService.setHttpListener(requestHolder.getHttpListener());
        httpService.setUrl(requestHolder.getUrl());
        //增加方法
        IHttpListener httpListener = requestHolder.getHttpListener();
        httpListener.addHttpHeader(httpService.getHttpHeadMap());

        try {
            T request = requestHolder.getRequestInfo();
            if (request != null) {
                String requestInfo= JSON.toJSONString(request);
                httpService.setRequestData(requestInfo.getBytes("UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        httpService.execute();
    }

    public void start() {
        futureTask = new FutureTask(this,null);
        try {

            ThreadPoolManager.getInstance().execute(futureTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        httpService.pause();
        if(futureTask != null) {
            ThreadPoolManager.getInstance().removeTask(futureTask);
        }
    }
}
