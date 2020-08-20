package com.hujian.coverflowmusic.presenter;

import android.system.ErrnoException;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.lrc.LrcResponse;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IAlbum;

import java.io.IOException;

public class AlbumPresenterImpl implements IAlbum {

    //专辑详情
    String album= "http://10.0.70.30:3000/album?id=32311";

    @Override
    public void getAlbum(final int id) {
        String url = AppConstant.HOST+"album?id="+id;
        final Request request =new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {
                if (request!=null&& !TextUtils.isEmpty(response.body().string())){
                    Gson gson = new GsonBuilder().create();
                    LrcResponse lrcResponse = gson.fromJson(response.body().string(), LrcResponse.class);
                }else {
                    throw new IllegalArgumentException("no data");
                }
            }
            @Override
            public void onFail(Request request, IOException e) {
            }
        });
    }
}
