package com.hujian.coverflowmusic.bean.model.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.hujian.coverflowmusic.bean.model.ISong;


/**
 * Copyright (C), 2015-2020
 * FileName: Song
 * Author: hujian
 * Date: 2020/8/21 10:46
 * History:
 * <author> <time> <version> <desc>
 */
@Entity
public class Song implements ISong {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "song_id")
    public String SongId;

    @ColumnInfo(name = "album_name")
    public String albumName;

    @ColumnInfo(name = "album_id")
    public String albumId;

    @ColumnInfo(name = "album_pic")
    public String albumPic;

    @ColumnInfo(name = "artist_name")
    public String artistName;

    @ColumnInfo(name = "artist_id")
    public String artistId;

    @ColumnInfo(name = "play_url")
    public String playUrl;

    @ColumnInfo(name = "size")
    public String size;

    @ColumnInfo(name = "lrc")
    public String lrc;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSongId() {
        return null;
    }

    @Override
    public String getAlbumName() {
        return null;
    }

    @Override
    public String getAlbumId() {
        return null;
    }

    @Override
    public String getAlbumPic() {
        return null;
    }

    @Override
    public String getArtistName() {
        return null;
    }

    @Override
    public String getArtistId() {
        return null;
    }

    @Override
    public String getPlayUrl() {
        return null;
    }

    @Override
    public String getSize() {
        return null;
    }

    @Override
    public String getLrc() {
        return null;
    }
}
