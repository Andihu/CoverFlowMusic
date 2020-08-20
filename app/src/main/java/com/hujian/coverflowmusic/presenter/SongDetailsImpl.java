package com.hujian.coverflowmusic.presenter;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.ISongDetails;

import java.io.IOException;

public class SongDetailsImpl implements ISongDetails {

    //歌曲详情
    String song = "http://10.0.70.30:3000/song/detail?ids=347230";
    @Override
    public void getSongDetails(Long id) {
        String url = AppConstant.HOST+"song/detail?ids="+id;
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
