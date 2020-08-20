package com.hujian.coverflowmusic.presenter;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IIrc;

import java.io.IOException;

public class IrcPresenterImpl implements IIrc {
    //歌词
    String lrc = "http://10.0.70.30:3000/lyric?id=33894312";
    @Override
    public void getIrc(int id) {
        String url = AppConstant.HOST+"lyric?id="+id;
        Request request =new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {

            }

            @Override
            public void onFail(Request request, IOException e) {

            }
        });
    }
}
