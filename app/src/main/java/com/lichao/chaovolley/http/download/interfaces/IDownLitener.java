package com.lichao.chaovolley.http.download.interfaces;

import com.lichao.chaovolley.http.interfaces.IHttpListener;
import com.lichao.chaovolley.http.interfaces.IHttpService;

/**
 * Created by Administrator on 2018-02-03.
 */

public interface IDownLitener extends IHttpListener {

    void setHttpServive(IHttpService httpServive);

    void  setCancleCalle();

    void  setPuaseCallble();
}
