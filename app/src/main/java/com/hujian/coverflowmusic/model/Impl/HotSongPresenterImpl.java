package com.hujian.coverflowmusic.model.Impl;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.hotmusic.HotSongResponse;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IHotMusicPresenter;

import java.io.IOException;

/**
 * Copyright (C), 2015-2020
 * FileName: getHotSongPresenterImpl
 * Author: hujian
 * Date: 2020/8/21 15:49
 * History:
 * <author> <time> <version> <desc>
 */

/**
 * 全部:0
 * <p>
 * 华语:7
 * <p>
 * 欧美:96
 * <p>
 * 日本:8
 * <p>
 * 韩国:16
 * 新歌速递
 * top/song
 * /top/song?type=96
 * http://10.0.70.30:3000/top/song
 */
public class HotSongPresenterImpl implements IHotMusicPresenter {

    private IHotMusicPresenter.HotSongView view;

    public HotSongPresenterImpl(HotSongView view) {
        this.view = view;
    }

    @Override
    public void getHotSong() {
        String url = AppConstant.HOST + "top/song";
        final Request request = new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {
                if (request != null && !TextUtils.isEmpty(response.body().string())) {
                    Gson gson = new GsonBuilder().create();
                    final HotSongResponse albumResponse = gson.fromJson(response.body().string(), HotSongResponse.class);
                    if (view != null) {
                        view.onLoadSuccess(albumResponse);
                    }
                } else {
                    //返回一个空的数据
                    if (view != null) {
                        view.onLoadFailed("");
                    }
                    throw new IllegalArgumentException("no data");
                }
            }

            @Override
            public void onFail(Request request, IOException e) {
                if (view != null) {
                    view.onLoadFailed("load netAlbum failed:" + e.getMessage());
                }
            }
        });
    }
}
