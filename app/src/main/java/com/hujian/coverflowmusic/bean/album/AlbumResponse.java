package com.hujian.coverflowmusic.bean.album;

import com.hujian.coverflowmusic.bean.album.Album;
import com.hujian.coverflowmusic.bean.song.Songs;

import java.util.List;

/**
 * Auto-generated: 2020-08-20 16:44:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AlbumResponse {

    private List<Songs> songs;
    private int code;
    private Album album;

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

}