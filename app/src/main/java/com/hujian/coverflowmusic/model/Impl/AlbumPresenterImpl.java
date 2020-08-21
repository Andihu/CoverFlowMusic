package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.album.Album;
import com.hujian.coverflowmusic.bean.album.AlbumResponse;
import com.hujian.coverflowmusic.bean.lrc.LrcResponse;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IAlbumPresenter;

import java.io.IOException;

/**
 * 专辑详情
 * http://10.0.70.30:3000/album?id=32311;
 */
public class AlbumPresenterImpl implements IAlbumPresenter {

    private AlbumView view;

    public AlbumPresenterImpl(AlbumView view) {
        this.view = view;
    }

    @Override
    public void getNetAlbumDetail(int id) {
        String url = AppConstant.HOST + "album?id=" + id;
        final Request request = new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {
                if (request != null && !TextUtils.isEmpty(response.body().string())) {
                    Gson gson = new GsonBuilder().create();
                    final AlbumResponse albumResponse = gson.fromJson(response.body().string(), AlbumResponse.class);
                    if (view != null) {
                        view.loadSuccess(albumResponse.getAlbum());
                    }
                } else {
                    //返回一个空的数据
                    if (view != null) {
                        view.loadSuccess(new Album());
                    }
                    throw new IllegalArgumentException("no data");
                }
            }

            @Override
            public void onFail(Request request, IOException e) {
                if (view != null) {
                    view.loadFailed("load netAlbum failed:" + e.getMessage());
                }
            }
        });
    }
}
