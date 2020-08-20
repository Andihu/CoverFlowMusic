package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.songlist.Playlist;
import com.hujian.coverflowmusic.bean.songlists.Playlists;

public interface ISongService {

    /**
     * 获取精品歌单
     * @return
     */
    Playlists getPopularSongList();

    /**
     * 获取歌单详情
     */
    Playlist getSongListDetails();

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
