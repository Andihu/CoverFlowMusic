package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.ISongPresenter;

import java.io.IOException;

/**
 * 歌曲详情
 * http://10.0.70.30:3000/song/detail?ids=347230
 */
public class SongDetailsImpl implements ISongPresenter {

    private SongView songView;

    private Context mContext;

    public SongDetailsImpl(SongView songView, Context context) {
        this.songView = songView;
        mContext = context;
    }

    @Override
    public void loadSongDetails(long id) {
        String url = AppConstant.HOST + "song/detail?ids=" + id;
        Request request = new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override public void onResponse(Response response) {

            }

            @Override public void onFail(Request request, IOException e) {

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
