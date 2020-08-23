package com.hujian.coverflowmusic.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hujian.coverflowmusic.R;
import com.hujian.coverflowmusic.Utils.StatusBarUtil;
import com.hujian.coverflowmusic.bean.hotmusic.Data;
import com.hujian.coverflowmusic.bean.hotmusic.HotSongResponse;
import com.hujian.coverflowmusic.bean.model.Dao.PlayList;
import com.hujian.coverflowmusic.bean.model.Dao.Song;
import com.hujian.coverflowmusic.bean.songlists.Playlists;
import com.hujian.coverflowmusic.model.IHighQualitySongListPresenter;
import com.hujian.coverflowmusic.model.IHotMusicPresenter;
import com.hujian.coverflowmusic.model.Impl.HighQualitySongListPresenterImpl;
import com.hujian.coverflowmusic.model.Impl.HotSongPresenterImpl;
import com.hujian.coverflowmusic.view.MainAdapter;
import com.hujian.coverflowmusic.view.PlayListAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements
        IHighQualitySongListPresenter.HighQualitySongListView,
        IHotMusicPresenter.HotSongView {

    public static final String KEY_DATA="KEY_DATA";
    private static final String TAG = "MainActivity";

    private IHighQualitySongListPresenter presenter;
    private IHotMusicPresenter hotMusicPresenter;
    private RecyclerView recyclerView;
    private MainAdapter playListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StatusBarUtil.setStatusBarLightMode(getWindow());
        setContentView(R.layout.activity_main);
        initVIew();
        presenter = new HighQualitySongListPresenterImpl(this, this);
        hotMusicPresenter = new HotSongPresenterImpl(this);
        presenter.getHighQualitySongList(4, System.currentTimeMillis());
        hotMusicPresenter.getHotSong();
    }

    private void initVIew() {
        recyclerView = findViewById(R.id.list);
        playListAdapter = new MainAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(playListAdapter);
        playListAdapter.setPlayListClickListener(new PlayListAdapter.OnItemClickListener() {
            @Override
            public void onClick(PlayList playList) {
                goPlayListDetails(playList);
            }
        });
        playListAdapter.setMusicClickListener(new MainAdapter.OnMusicClickListener() {
            @Override
            public void onClick(Song song) {
                goMusicDetails(song);
            }
        });
    }

    private void goMusicDetails(Song song) {
    }

    private void goPlayListDetails(PlayList playList) {
        Intent intent =new Intent(this,PlayListDetails.class);
        Bundle bundle =new Bundle();
        bundle.putString(PlayListDetails.KEY_PLAYLIST_ID,playList.getPlayListId());
        bundle.putString(PlayListDetails.KEY_PLAYLIST_IMG,playList.getCoverImageUrl());
        bundle.putString(PlayListDetails.KEY_PLAYLIST_NAME,playList.getName());
        bundle.putString(PlayListDetails.KEY_PLAYLIST_DESC,playList.getDescription());
        bundle.putString(PlayListDetails.KEY_PLAYLIST_COUNT,playList.getTackCount());
        bundle.putString(PlayListDetails.KEY_PLAYLIST_CREATOR_NAME,playList.getCreatorName());
        bundle.putString(PlayListDetails.KEY_PLAYLIST_CREATOR_IMG,playList.getCreatorAvatar());
        bundle.putString(PlayListDetails.KEY_PLAYLIST_TAG,playList.getTag());
        intent.putExtra(KEY_DATA,bundle);
        this.startActivity(intent);
    }


    @Override
    public void loadSuccess(List<Playlists> result) {
        List<PlayList> list = new ArrayList<>();
        for (Playlists playlists : result) {
            list.add(PlayList.toPlayList(playlists));
        }
        playListAdapter.setPlayListData(list);
    }

    @Override
    public void loadFailed(String message) {

    }

    @Override
    public void onLoadSuccess(HotSongResponse result) {
        long start = System.currentTimeMillis();
        List hosSong = new ArrayList<>();
        for (Data data : result.getData()) {
            hosSong.add(Song.toSong(data));
        }
        playListAdapter.setHotSongData(hosSong);
        Log.e(TAG, "onLoadSuccess: time:" + (System.currentTimeMillis() - start));
    }

    @Override
    public void onLoadFailed(String message) {

    }
}