package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.lrc.Klyric;
import com.hujian.coverflowmusic.bean.lrc.Lrc;
import com.hujian.coverflowmusic.bean.lrc.LrcResponse;
import com.hujian.coverflowmusic.bean.songlists.HighQualitySongListResponse;
import com.hujian.coverflowmusic.bean.songlists.Playlists;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.ILrcPresenter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 歌词
 * http://10.0.70.30:3000/lyric?id=33894312
 */
public class IrcPresenterImpl implements ILrcPresenter {

    private Context context;

    private LrcView view;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    public IrcPresenterImpl(Context context, LrcView view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getLrc(int id) {
        String url = AppConstant.HOST+"lyric?id="+id;
        Request request =new Request.Builder().url(url).build();
        CHttpClient cHttpClient = new CHttpClient.Builder().build();
        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {
                if (response != null && !TextUtils.isEmpty(response.body().string())) {
                    Gson gson = new GsonBuilder().create();
                    final LrcResponse lrcResponse = gson.fromJson(response.body().string(), LrcResponse.class);
                    if (view != null) {
                        view.loadSuccess(lrcResponse.getLrc().getLyric());
                    }
                } else {
                    //返回一个空的数据
                    if (view != null) {
                        view.loadSuccess("");
                    }
                    throw new IllegalArgumentException("no data");
                }
            }

            @Override
            public void onFail(Request request, IOException e) {
                if (view != null) {
                    view.loadFailed("load netLrc failed:" + e.getMessage());
                }
            }
        });
    }

    @Override
    public void getLocalLrc(int id) {

    }

    @Override
    public void saveLocalLrc(Lrc lrc) {

    }

    @Override
    public void removeLocalLrc() {

    }

}
