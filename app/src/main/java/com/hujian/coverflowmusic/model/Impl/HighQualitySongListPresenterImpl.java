package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.album.Album;
import com.hujian.coverflowmusic.bean.album.AlbumResponse;
import com.hujian.coverflowmusic.bean.songlists.HighQualitySongListResponse;
import com.hujian.coverflowmusic.bean.songlists.Playlists;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IHighQualitySongListPresenter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 热门歌单
 * "http://10.0.70.30:3000/top/playlist/highquality?before=1503639064232&limit=3";
 */
public class HighQualitySongListPresenterImpl implements IHighQualitySongListPresenter {


    private Context context;

    private HighQualitySongListView view;

    public HighQualitySongListPresenterImpl(Context context, HighQualitySongListView view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getHighQualitySongList(int limit, Long before) {
        String url = AppConstant.HOST+"top/playlist/highquality?before="+before+"&limit="+limit;
        Request request =new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {
                if (response != null && !TextUtils.isEmpty(response.body().string())) {
                    Gson gson = new GsonBuilder().create();
                    final HighQualitySongListResponse qualitySongListResponse = gson.fromJson(response.body().string(), HighQualitySongListResponse.class);
                    if (view != null) {
                        view.loadSuccess(qualitySongListResponse.getPlaylists());
                    }
                } else {
                    //返回一个空的数据
                    if (view != null) {
                        view.loadSuccess(new ArrayList<Playlists>());
                    }
                    throw new IllegalArgumentException("no data");
                }
            }

            @Override
            public void onFail(Request request, IOException e) {
                if (view != null) {
                    view.loadFailed("load netPlayLists failed:" + e.getMessage());
                }
            }
        });

    }
}
