package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.album.Album;
import com.hujian.coverflowmusic.bean.songlist.PlaylistResponse;

import java.util.List;

/**
 * Copyright (C), 2015-2020
 * FileName: IPlayList
 * Author: hujian
 * Date: 2020/8/20 18:38
 * History:
 * <author> <time> <version> <desc>
 */
public interface IPlayList {

    void getPlayList(PlaylistResponse list);

    interface Callback {

        void onLoaded(List<Album> albums);

        void onLoadFailed();
    }
}
