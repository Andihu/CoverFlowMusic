package com.hujian.coverflowmusic.bean.song;

import java.util.List;

/**
 * Auto-generated: 2020-08-20 16:36:53
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
//artist
public class Ar {

    private int id;
    private String name;
    private List<String> tns;
    private List<String> alias;

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

    public void setTns(List<String> tns) {
        this.tns = tns;
    }

    public List<String> getTns() {
        return tns;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public List<String> getAlias() {
        return alias;
    }

}