package com.lichao.chaovolley.http;

import com.lichao.chaovolley.http.interfaces.IHttpListener;
import com.lichao.chaovolley.http.interfaces.IHttpService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2018-02-01.
 */

public class JsonHttpService implements IHttpService {
    private IHttpListener httpListener;

    private HttpClient httpClient = new DefaultHttpClient();
    private HttpPost httpPost;
    private String url;

    private byte[] requestData;
    //httpClient获取网络的回调
    private HttpResponseHandler httpResponseHandler = new HttpResponseHandler();

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        httpPost = new HttpPost();
        if (requestData != null && requestData.length > 0) {
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(requestData);
            httpPost.setEntity(byteArrayEntity);
        }
        try {
            httpClient.execute(httpPost, httpResponseHandler);
        } catch (IOException e) {
            httpListener.onFail();
        }
    }

    @Override
    public void setHttpListener(IHttpListener httpListener) {
        this.httpListener = httpListener;
    }

    @Override
    public void setRequestData(byte[] requestData) {
        this.requestData = requestData;
    }

    @Override
    public void pause() {

    }

    @Override
    public Map<String, String> getHttpHeadMap() {
        return null;
    }

    @Override
    public boolean Cancel() {
        return false;
    }

    @Override
    public boolean isCancel() {
        return false;
    }

    @Override
    public boolean isPause() {
        return false;
    }

    private class HttpResponseHandler extends BasicResponseHandler {
        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            //响应码
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                httpListener.onSuccess(response.getEntity());
            } else {
                httpListener.onFail();
            }
            return null;
        }
    }
}
