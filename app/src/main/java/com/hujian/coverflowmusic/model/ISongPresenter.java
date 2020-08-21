package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.song.Songs;

import java.util.List;

public interface ISongPresenter {

    void loadSongDetails(long id);

    void loadSongUrl(long id);

    void loadAllLocalSong();

    void loadLocalSong(long id);

    interface SongView {

        void onLoadSuccess(List<Songs> result);

        void onLoadFailed( String message);

    }

}
