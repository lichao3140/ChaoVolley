package com.lichao.chaovolley.http.interfaces;

/**
 * Created by Administrator on 2018-02-01.
 */

public interface IDataListener<M> {
    /**
     * 回调成功结果
     * @param m
     */
    void onSuccess(M m);

    /**
     * 回调失败结果
     */
    void onError();
}
