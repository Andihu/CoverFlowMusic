package com.hujian.coverflowmusic.bean.model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Copyright (C), 2015-2020
 * FileName: SongDao
 * Author: hujian
 * Date: 2020/8/21 11:17
 * History:
 * <author> <time> <version> <desc>
 */
@Dao
public interface SongDataDao {

    @Query("SELECT * FROM song")
    List<Song> getAllSong ();

    @Query("SELECT * FROM song WHERE song_id IN (:songIds)")
    List<Song> loadAllSongByIds(int... songIds);

    @Query("SELECT * FROM song WHERE song_id = :id")
    Song findSongById(int id);

    @Query("SELECT * FROM song WHERE album_id = (:albumIds)")
    List<Song> loadAlbumSongByIds(int albumIds);

    @Insert
    void insertAllSong(Song... users);

    @Delete
    void deleteSong(Song user);


    @Query("SELECT * FROM playlist")
    List<PlayList> getAllPlayList();

    @Query("SELECT * FROM playlist WHERE play_list_id IN (:playListIds)")
    List<PlayList> loadAllPlayListByIds(int... playListIds);

    @Query("SELECT * FROM playlist WHERE play_list_id = :id")
    PlayList findPlayListById(int id);

    @Insert
    void insertAllPlayList(PlayList... users);

    @Delete
    void deletePlayList(PlayList user);
}
