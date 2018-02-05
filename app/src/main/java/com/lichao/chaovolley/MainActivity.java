package com.lichao.chaovolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.lichao.chaovolley.http.Volley;
import com.lichao.chaovolley.http.interfaces.IDataListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lichao";
    public static final String url = "http://v.juhe.cn/toutiao/index?type=top&key=bc7c0000b8bb8b651f06054811fcfbab";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
//        User user = new User();
//        user.setName("lichao");
//        user.setPassword("123456");
        Volley.sendRequest(null, url, NewsPager.class, new IDataListener<NewsPager>() {
            @Override
            public void onSuccess(NewsPager loginResponse) {
                Log.i(TAG, loginResponse.toString());
            }

            @Override
            public void onError() {
                Log.i(TAG, "获取失败");
            }
        });
    }
}
