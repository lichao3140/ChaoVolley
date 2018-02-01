package com.lichao.chaovolley.http.interfaces;

import org.apache.http.HttpEntity;

import java.util.Map;

/**
 * Created by Administrator on 2018-02-01.
 */

public interface IHttpListener {
    /**
     * 网络访问
     * 处理结果  回调
     * @param httpEntity
     */
    void onSuccess(HttpEntity httpEntity);

    void onFail();

    void addHttpHeader(Map<String,String> headerMap);
}
