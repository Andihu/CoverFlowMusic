package com.hujian.coverflowmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hujian.coverflowmusic.bean.song.SongResponse;
import com.hujian.coverflowmusic.bean.songlist.PlaylistResponse;
import com.hujian.coverflowmusic.bean.songlists.HighQualitySongList;
import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.RequestCallback;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //热门歌单
    String highquality = "http://10.0.70.30:3000/top/playlist/highquality?before=1503639064232&limit=3";

    //歌单详情
    String playList = "http://10.0.70.30:3000/playlist/detail?id=24381616";

    //歌曲详情
    String song = "http://10.0.70.30:3000/song/detail?ids=347230";

    //专辑详情
    String album= "http://10.0.70.30:3000/album?id=32311";

    //歌词
    String lrc = "http://10.0.70.30:3000/lyric?id=33894312";

    //搜索
    String search ="http://10.0.70.30:3000/search?keywords= 海阔天空";

    //获取播放连接

    String playUrl ="http://10.0.70.30:3000/song/url?id=33894312";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Request request =new Request.Builder().url(highquality).build();

        CHttpClient cHttpClient = new CHttpClient.Builder().build();

        cHttpClient.newCall(request).enqueue(new RequestCallback() {
            @Override
            public void onResponse(Response response) {
                Log.d(TAG, "onResponse: "+response.body().string()+"message||"+response.message()+"||code:"+response.code());
                Gson go = new GsonBuilder().create();
                HighQualitySongList highQualitySongList = go.fromJson(response.body().string(), HighQualitySongList.class);
//                PlaylistResponse PlaylistResponse = go.fromJson(response.body().string(), PlaylistResponse.class);
//                SongResponse SongResponse = go.fromJson(response.body().string(), SongResponse.class);
//                AlbumResponse AlbumResponse = go.fromJson(response.body().string(), AlbumResponse.class);
//                LrcResponse LrcResponse = go.fromJson(response.body().string(), LrcResponse.class);
            }
            @Override
            public void onFail(Request request, IOException e) {
                Log.d(TAG, "onFail: request"+request.toString());
            }
        });
    }
}