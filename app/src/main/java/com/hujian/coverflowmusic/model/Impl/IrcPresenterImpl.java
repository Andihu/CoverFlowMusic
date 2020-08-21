package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.bean.lrc.Lrc;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.ILrcPresenter;

import java.io.IOException;

/**
 * 歌词
 * http://10.0.70.30:3000/lyric?id=33894312
 */
public class IrcPresenterImpl implements ILrcPresenter {

    private Context context;

    private LrcView view;

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

            }

            @Override
            public void onFail(Request request, IOException e) {

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
