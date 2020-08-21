package com.hujian.coverflowmusic.model;


public interface ISongPresenter {

    void loadSongDetails(long id);

    void loadSongUrl(long id);

    void loadAllLocalSong();

    void loadLocalSong(long id);

    interface SongView {

        void onLoadSuccess();

        void onLoadFailed(int code, String message);

    }

}
