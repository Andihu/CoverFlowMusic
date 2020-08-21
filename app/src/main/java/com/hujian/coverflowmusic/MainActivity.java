package com.hujian.coverflowmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.hujian.coverflowmusic.Utils.StatusBarUtil;
import com.hujian.coverflowmusic.bean.model.Dao.PlayList;
import com.hujian.coverflowmusic.bean.songlists.Playlists;
import com.hujian.coverflowmusic.model.IHighQualitySongListPresenter;
import com.hujian.coverflowmusic.model.Impl.HighQualitySongListPresenterImpl;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements IHighQualitySongListPresenter.HighQualitySongListView {
    private static final String TAG = "MainActivity";
    private IHighQualitySongListPresenter presenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarLightMode(getWindow());
        setContentView(R.layout.activity_main);

        presenter=new HighQualitySongListPresenterImpl(this,this);

        presenter.getHighQualitySongList(4,System.currentTimeMillis());

    }



    @Override
    public void loadSuccess(List<Playlists> result) {
        List<PlayList> list =new ArrayList<>();
        for (Playlists playlists : result) {
            list.add(PlayList.toPlayList(playlists));
        }
    }

    @Override
    public void loadFailed(String message) {

    }
}