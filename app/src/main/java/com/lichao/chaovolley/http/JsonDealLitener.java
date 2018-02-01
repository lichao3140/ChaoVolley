package com.lichao.chaovolley.http;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.lichao.chaovolley.http.interfaces.IDataListener;
import com.lichao.chaovolley.http.interfaces.IHttpListener;

import org.apache.http.HttpEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * M  对应响应类
 * Created by Administrator on 2018-02-01.
 */

public class JsonDealLitener<M> implements IHttpListener {
    private Class<M> response;

    /**
     * 回调调用层的接口
     */
    private IDataListener<M> dataListener;

    Handler handler = new Handler(Looper.getMainLooper());

    public JsonDealLitener(Class<M> response, IDataListener<M> dataListener) {
        this.response = response;
        this.dataListener = dataListener;
    }

    @Override
    public void onSuccess(HttpEntity httpEntity) {
        InputStream inputStream = null;
        try {
            inputStream = httpEntity.getContent();
            //得到网络返回的数据子线程
            String content = getContent(inputStream);
            final M m = JSON.parseObject(content, response);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    dataListener.onSuccess(m);
                }
            });
        } catch (IOException e) {
            dataListener.onError();
        }
    }

    @Override
    public void onFail() {

    }

    @Override
    public void addHttpHeader(Map<String, String> headerMap) {

    }

    /**
     * InputStream 转 String
     * @param inputStream
     * @return
     */
    private String getContent(InputStream inputStream) {
        String content = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                dataListener.onError();
                System.out.println("Error=" + e.toString());
            } finally {
                inputStream.close();
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            dataListener.onError();
        }
        return content;
    }
}
