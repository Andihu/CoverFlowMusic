package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.album.Album;
import com.hujian.coverflowmusic.bean.songlists.HighQualitySongList;

import java.util.List;

/**
 * Copyright (C), 2015-2020
 * FileName: IHightQualitySongList
 * Author: hujian
 * Date: 2020/8/20 18:33
 * History:
 * <author> <time> <version> <desc>
 */
public interface IHighQualitySongList {

    void getHighQualitySongList(int limit, Long before);

}
