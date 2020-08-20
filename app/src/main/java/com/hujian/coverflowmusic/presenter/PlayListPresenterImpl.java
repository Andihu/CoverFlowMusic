package com.hujian.coverflowmusic.presenter;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.songlist.PlaylistResponse;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IPlayList;

import java.io.IOException;

public class PlayListPresenterImpl implements IPlayList {

    //歌单详情
    String playList = "http://10.0.70.30:3000/playlist/detail?id=24381616";
    @Override
    public void getNetPlayList(Long id) {
        String url = AppConstant.HOST+"playlist/detail?id="+id;
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

    @Override
    public void getLocalPlayList() {

    }
}
