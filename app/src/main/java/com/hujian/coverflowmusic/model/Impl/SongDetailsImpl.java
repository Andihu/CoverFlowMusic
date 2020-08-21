package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.song.SongResponse;
import com.hujian.coverflowmusic.bean.song.Songs;
import com.hujian.coverflowmusic.bean.songlist.PlaylistResponse;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.ISongPresenter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 歌曲详情
 * http://10.0.70.30:3000/song/detail?ids=347230
 */
public class SongDetailsImpl implements ISongPresenter {

    private SongView view;

    private Context mContext;

    public SongDetailsImpl(SongView songView, Context context) {
        this.view = songView;
        mContext = context;
    }

    @Override
    public void loadSongDetails(long id) {
        String url = AppConstant.HOST + "song/detail?ids=" + id;
        Request request = new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {
                if (response != null && !TextUtils.isEmpty(response.body().string())) {
                    Gson gson = new GsonBuilder().create();
                    final SongResponse songResponse = gson.fromJson(response.body().string(), SongResponse.class);
                    if (view != null) {
                        view.onLoadSuccess(songResponse.getSongs());
                    }
                } else {
                    //返回一个空的数据
                    if (view != null) {
                        view.onLoadSuccess(new ArrayList<Songs>());
                    }
                    throw new IllegalArgumentException("no data");
                }
            }

            @Override
            public void onFail(Request request, IOException e) {
                if (view != null) {
                    view.onLoadFailed("load netLSongDetail failed:" + e.getMessage());
                }
            }
        });
    }

    @Override
    public void loadSongUrl(long id) {

    }

    @Override
    public void loadAllLocalSong() {

    }

    @Override
    public void loadLocalSong(long id) {

    }
}
