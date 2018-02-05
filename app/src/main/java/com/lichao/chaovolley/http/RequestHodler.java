package com.lichao.chaovolley.http;

import com.lichao.chaovolley.http.interfaces.IHttpListener;
import com.lichao.chaovolley.http.interfaces.IHttpService;

/**
 * Created by Administrator on 2018-02-05.
 */

public class RequestHodler<T> {
    /**
     * 执行下载类
     */
    private IHttpService httpService;
    /**
     * 获取数据  回调结果的类
     */
    private IHttpListener httpListener;
    /**
     * 请求参数对应的实体
     */
    private T requestInfo;

    private String url;

    public IHttpService getHttpService() {
        return httpService;
    }

    public void setHttpService(IHttpService httpService) {
        this.httpService = httpService;
    }

    public IHttpListener getHttpListener() {
        return httpListener;
    }

    public void setHttpListener(IHttpListener httpListener) {
        this.httpListener = httpListener;
    }

    public T getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(T requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
