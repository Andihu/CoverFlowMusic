package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.Playlists;
import com.hujian.coverflowmusic.bean.PopularSongList;

public interface ISongService {

    /**
     * 获取精品歌单
     * @return
     */
   PopularSongList getPopularSongList();

    /**
     * 获取歌单详情
     */
    Playlists getSongListDetails();

    /**
     * 获取歌曲详情
     */

    Object getSongDetails();

    /**
     * 获取歌手详情
     */
    Object getArtistDetails();

    /**
     * 获取专辑详情
     */

    Object getAlbumDetails();

}
