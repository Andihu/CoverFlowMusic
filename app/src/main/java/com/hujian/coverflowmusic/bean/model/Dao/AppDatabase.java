package com.hujian.coverflowmusic.bean.model.Dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Copyright (C), 2015-2020
 * FileName: AppDatabase
 * Author: hujian
 * Date: 2020/8/21 11:46
 * History:
 * <author> <time> <version> <desc>
 */
@Database(entities = {Song.class,PlayList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public  static  final String DATABASE_NAME="music_room.db";
    public abstract SongDataDao songDataDao();
}