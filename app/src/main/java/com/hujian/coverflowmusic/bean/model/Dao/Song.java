package com.hujian.coverflowmusic.bean.model.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.hujian.coverflowmusic.bean.hotmusic.Data;
import com.hujian.coverflowmusic.bean.model.ISong;

import com.hujian.coverflowmusic.bean.songlist.Playlist;
import com.hujian.coverflowmusic.bean.songlist.TrackIds;
import com.hujian.coverflowmusic.bean.songlist.Tracks;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SongId='" + SongId + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumId='" + albumId + '\'' +
                ", albumPic='" + albumPic + '\'' +
                ", artistName='" + artistName + '\'' +
                ", artistId='" + artistId + '\'' +
                ", duration=" + duration +
                ", artistPic='" + artistPic + '\'' +
                ", playUrl='" + playUrl + '\'' +
                ", size='" + size + '\'' +
                ", lrc='" + lrc + '\'' +
                '}';
    }

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

    @ColumnInfo(name = "duration")
    public long duration;

    @ColumnInfo(name = "artist_pic")
    public String artistPic;


    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSongId(String songId) {
        SongId = songId;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public void setAlbumPic(String albumPic) {
        this.albumPic = albumPic;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public void setArtistPic(String artistPic) {
        this.artistPic = artistPic;
    }

    @ColumnInfo(name = "play_url")
    public String playUrl;

    @ColumnInfo(name = "size")
    public String size;

    @ColumnInfo(name = "lrc")
    public String lrc;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSongId() {
        return SongId;
    }

    @Override
    public String getAlbumName() {
        return albumName;
    }

    @Override
    public String getAlbumId() {
        return albumId;
    }

    @Override
    public String getAlbumPic() {
        return albumPic;
    }

    @Override
    public String getArtistName() {
        return artistName;
    }

    @Override
    public String getArtistId() {
        return artistId;
    }

    @Override
    public String getPlayUrl() {
        return playUrl;
    }

    @Override
    public String getArtistPic() {
        return artistPic;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getLrc() {
        return lrc;
    }

    @Override
    public long getDuration() {
        return duration;
    }


    public static Song toSong(Data data){
        Song song = new Song();
        song.setPlayUrl(data.getMp3Url());
        song.setId((int)data.getId());
        song.setName(data.getName());
        song.setDuration(data.getDuration());

        song.setAlbumId(String.valueOf(data.getAlbum().getId()));
        song.setAlbumName(data.getAlbum().getName());
        song.setAlbumPic(data.getAlbum().getPicUrl());

        song.setArtistId(String.valueOf(data.getArtists().get(0).getId()));
        song.setArtistName(String.valueOf(data.getArtists().get(0).getName()));
        song.setArtistPic(data.getArtists().get(0).getPicUrl());
        return song;
    }

    public static List<Song> toSongsFromPlayList(Playlist playlist){
        List<Tracks> tracks = playlist.getTracks();
        List<Song> songs =new ArrayList<>();
        for (Tracks track : tracks) {
            Song song =new Song();
            song.setName(track.getName());
            song.setArtistPic(track.getAr().get(0).getName());
            song.setArtistId(String.valueOf(track.getAr().get(0).getId()));
            song.setAlbumPic(track.getAl().getPicUrl());
            song.setAlbumName(track.getAl().getName());
            song.setAlbumId(String.valueOf(track.getAl().getId()));
            songs.add(song);
        }
        return songs;
    }
}
