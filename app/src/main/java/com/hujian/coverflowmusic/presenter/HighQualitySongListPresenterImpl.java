package com.hujian.coverflowmusic.presenter;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IHighQualitySongList;

import java.io.IOException;

public class HighQualitySongListPresenterImpl implements IHighQualitySongList {
    //热门歌单
    String highquality = "http://10.0.70.30:3000/top/playlist/highquality?before=1503639064232&limit=3";

    @Override
    public void getHighQualitySongList(int limit, Long before) {
        String url = AppConstant.HOST+"top/playlist/highquality?before="+before+"&limit="+limit;
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
