package com.hujian.coverflowmusic.bean;

import java.util.List;

/**
 * Auto-generated: 2020-08-18 20:22:58
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
//精品歌单 搜索
public class PopularSongList{
    private List<Playlists> playlists;
    private int code;
    private boolean more;
    private long lastTime;
    private int total;
    public void setPlaylists(List<Playlists> playlists) {
         this.playlists = playlists;
     }
     public List<Playlists> getPlaylists() {
         return playlists;
     }

    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setMore(boolean more) {
         this.more = more;
     }
     public boolean getMore() {
         return more;
     }

    public void setLastTime(long lastTime) {
         this.lastTime = lastTime;
     }
     public long getLastTime() {
         return lastTime;
     }

    public void setTotal(int total) {
         this.total = total;
     }
     public int getTotal() {
         return total;
     }
}