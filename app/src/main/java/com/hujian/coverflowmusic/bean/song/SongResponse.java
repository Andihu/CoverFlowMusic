package com.hujian.coverflowmusic.bean.song;

import java.util.List;

/**
 * Auto-generated: 2020-08-20 16:36:53
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SongResponse {

    private List<Songs> songs;
    private List<Privileges> privileges;
    private int code;

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setPrivileges(List<Privileges> privileges) {
        this.privileges = privileges;
    }

    public List<Privileges> getPrivileges() {
        return privileges;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}