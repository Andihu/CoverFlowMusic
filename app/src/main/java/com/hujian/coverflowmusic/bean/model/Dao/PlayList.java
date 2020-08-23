package com.hujian.coverflowmusic.bean.model.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.hujian.coverflowmusic.bean.model.IPlayList;
import com.hujian.coverflowmusic.bean.songlist.Playlist;
import com.hujian.coverflowmusic.bean.songlists.Playlists;

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
    public long id;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPlayListId(String playListId) {
        this.playListId = playListId;
    }

    public void setTackCount(String tackCount) {
        this.tackCount = tackCount;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setCreatorAvatar(String creatorAvatar) {
        this.creatorAvatar = creatorAvatar;
    }

    public void setCreatorAvatarBackground(String creatorAvatarBackground) {
        this.creatorAvatarBackground = creatorAvatarBackground;
    }

    public void setCreatorSignature(String creatorSignature) {
        this.creatorSignature = creatorSignature;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public String getPlayListId() {
        return playListId;
    }

    @Override
    public String getTackCount() {
        return tackCount;
    }

    @Override
    public String getCreatorName() {
        return creatorName;
    }

    @Override
    public String getCreatorAvatar() {
        return creatorAvatar;
    }

    @Override
    public String getCreatorAvatarBackground() {
        return creatorAvatarBackground;
    }

    @Override
    public String getCreatorSignature() {
        return creatorSignature;
    }

    public static PlayList toPlayList(Playlists playlists){
        PlayList playlist =new PlayList();
        playlist.setDescription(playlists.getDescription());
        playlist.setCoverImageUrl(playlists.getCoverImgUrl());
        playlist.setCreatorAvatar(playlists.getCreator().getAvatarUrl());
        playlist.setCreatorAvatarBackground(playlists.getCreator().getBackgroundUrl());
        playlist.setCreatorName(playlists.getCreator().getNickname());
        playlist.setCreatorSignature(playlists.getCreator().getSignature());
        playlist.setName(playlists.getName());
        playlist.setPlayListId(String.valueOf(playlists.getId()));
        playlist.setTag(playlists.getTag());
        playlist.setTackCount(playlists.getTrackCount()+"");
        return playlist;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", playListId='" + playListId + '\'' +
                ", tackCount='" + tackCount + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", creatorAvatar='" + creatorAvatar + '\'' +
                ", creatorAvatarBackground='" + creatorAvatarBackground + '\'' +
                ", creatorSignature='" + creatorSignature + '\'' +
                '}';
    }
}
