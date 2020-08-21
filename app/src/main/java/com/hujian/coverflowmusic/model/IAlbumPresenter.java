package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.album.Album;

public interface IAlbumPresenter {

    void getNetAlbumDetail(int id);


    interface AlbumView{

        void loadSuccess(Album Album);

        void loadFailed(String message);

    }

}
