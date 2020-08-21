package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.songlist.Playlist;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IPlayListPresenter;

import java.io.IOException;

/**
 * 歌单详情
 * http://10.0.70.30:3000/playlist/detail?id=24381616
 */
public class PlayListPresenterImpl implements IPlayListPresenter {

    private Context context;

    private PlayListView playListView;


    public PlayListPresenterImpl(PlayListView playListView, Context context) {
        this.playListView = playListView;
        this.context = context;
    }

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

    @Override
    public void savePlayList(Playlist playlist) {

    }

    @Override
    public void removeFavoritePlayList(long id) {

    }
}
