package com.hujian.coverflowmusic.model.Impl;

import android.content.Context;

import com.hujian.coverflowmusic.AppConstant;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Response;
import com.hujian.coverflowmusic.model.IHighQualitySongListPresenter;

import java.io.IOException;
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

            }

            @Override
            public void onFail(Request request, IOException e) {

            }
        });

    }
}
