package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.songlists.HighQualitySongListResponse;
import com.hujian.coverflowmusic.bean.songlists.Playlists;

import java.util.List;


/**
 * Copyright (C), 2015-2020
 * FileName: IHightQualitySongList
 * Author: hujian
 * Date: 2020/8/20 18:33
 * History:
 * <author> <time> <version> <desc>
 */
public interface IHighQualitySongListPresenter {

    void getHighQualitySongList(int limit, Long before);

    interface HighQualitySongListView{

        void loadSuccess(List<Playlists> result);

        void loadFailed(String message);
    }
}
