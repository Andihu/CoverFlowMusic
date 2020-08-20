package com.hujian.coverflowmusic.bean.song;

import java.util.List;

/**
 * Auto-generated: 2020-08-20 16:36:53
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
//album
public class Al {

    private int id;
    private String name;
    private String picUrl;
    private List<String> tns;
    private long pic;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setTns(List<String> tns) {
        this.tns = tns;
    }

    public List<String> getTns() {
        return tns;
    }

    public void setPic(long pic) {
        this.pic = pic;
    }

    public long getPic() {
        return pic;
    }

}