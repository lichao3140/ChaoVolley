package com.lichao.chaovolley.http;

import com.lichao.chaovolley.http.interfaces.IDataListener;
import com.lichao.chaovolley.http.interfaces.IHttpListener;
import com.lichao.chaovolley.http.interfaces.IHttpService;
import com.lichao.chaovolley.http.interfaces.RequestHolder;

import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2018-02-01.
 */

public class Volley {

    /**
     * 暴露给调用层
     * @param requestInfo
     * @param url
     * @param response
     * @param dataListener
     * @param <T>  请求参数类型
     * @param <M>  响应参数类型
     */
    public static <T, M> void sendRequest(T requestInfo, String url, Class<M> response, IDataListener dataListener) {
        RequestHolder<T> requestHolder = new RequestHolder<>();
        requestHolder.setUrl(url);
        //策略模式
        IHttpService httpService = new JsonHttpService();
        IHttpListener httpListener = new JsonDealLitener<>(response, dataListener);
        requestHolder.setHttpService(httpService);
        requestHolder.setHttpListener(httpListener);
        //将请求参数赋值
        requestHolder.setRequestInfo(requestInfo);

        HttpTask<T> httpTask = new HttpTask<>(requestHolder);
        try {
            ThreadPoolManager.getInstance().execute(new FutureTask<Object>(httpTask, null));
        } catch (InterruptedException e) {
            dataListener.onError();
        }
    }
}
