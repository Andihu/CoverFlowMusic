package com.hujian.coverflowmusic.bean.songlist;

import java.util.List;

/**
 * Auto-generated: 2020-08-20 16:12:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PlaylistResponse {

    private int code;
    private String relatedVideos;
    private Playlist playlist;
    private String urls;
    private List<Privileges> privileges;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setRelatedVideos(String relatedVideos) {
        this.relatedVideos = relatedVideos;
    }

    public String getRelatedVideos() {
        return relatedVideos;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getUrls() {
        return urls;
    }

    public void setPrivileges(List<Privileges> privileges) {
        this.privileges = privileges;
    }

    public List<Privileges> getPrivileges() {
        return privileges;
    }

}