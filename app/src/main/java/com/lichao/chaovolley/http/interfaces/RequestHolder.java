package com.lichao.chaovolley.http.interfaces;

/**
 * Created by Administrator on 2018-02-01.
 */

public class RequestHolder<T> {
    /**
     * 执行下载类
     */
    private IHttpService httpService;
    /**
     * 获取数据回调结果的类
     */
    private IHttpListener httpListener;
    /**
     * 请求参数对应的实体
     */
    private T requestInfo;
    /**
     * 请求地址
     */
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
