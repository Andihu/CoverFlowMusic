package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.songlist.Playlist;

/**
 * Copyright (C), 2015-2020
 * FileName: IPlayList
 * Author: hujian
 * Date: 2020/8/20 18:38
 * History:
 * <author> <time> <version> <desc>
 */
public interface IPlayListPresenter {

    void getNetPlayList(Long id);

    void getLocalPlayList();

    void savePlayList(Playlist playlist);

    void removeFavoritePlayList(long id);

    interface PlayListView{

        void onLoadSuccess(Playlist result);

        void onLoadFailed(String message);

    }

}
