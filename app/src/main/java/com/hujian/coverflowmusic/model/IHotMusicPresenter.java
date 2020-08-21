package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.hotmusic.HotSongResponse;

/**
 * Copyright (C), 2015-2020
 * FileName: IHotMusicPresenter
 * Author: hujian
 * Date: 2020/8/21 15:48
 * History:
 * <author> <time> <version> <desc>
 */
public interface IHotMusicPresenter {

    void getHotSong();

    interface HotSongView{

        void onLoadSuccess(HotSongResponse result);

        void onLoadFailed(String message);

    }
}
