package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.songlists.HighQualitySongList;


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

        void loadSuccess(HighQualitySongList list);

        void loadFailed(String message);
    }
}
