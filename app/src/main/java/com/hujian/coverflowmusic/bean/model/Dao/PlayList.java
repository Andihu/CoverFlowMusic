package com.hujian.coverflowmusic.bean.model.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.hujian.coverflowmusic.bean.model.IPlayList;

/**
 * Copyright (C), 2015-2020
 * FileName: PlayList
 * Author: hujian
 * Date: 2020/8/21 10:46
 * History:
 * <author> <time> <version> <desc>
 */
@Entity
public class PlayList  implements IPlayList {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "cover_image_url")
    public String coverImageUrl;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "tag")
    public String tag;

    @ColumnInfo(name = "play_list_id")
    public String playListId;

    @ColumnInfo(name = "tack_count")
    public String tackCount;

    @ColumnInfo(name = "creator_name")
    public String creatorName;

    @ColumnInfo(name = "creator_avatar")
    public String creatorAvatar;

    @ColumnInfo(name = "creator_avatar_background")
    public String creatorAvatarBackground;

    @ColumnInfo(name = "creator_signature")
    public String creatorSignature;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getCoverImageUrl() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getTag() {
        return null;
    }

    @Override
    public String getPlayListId() {
        return null;
    }

    @Override
    public String getTackCount() {
        return null;
    }

    @Override
    public String getCreatorName() {
        return null;
    }

    @Override
    public String getCreatorAvatar() {
        return null;
    }

    @Override
    public String getCreatorAvatarBackground() {
        return null;
    }

    @Override
    public String getCreatorSignature() {
        return null;
    }
}
