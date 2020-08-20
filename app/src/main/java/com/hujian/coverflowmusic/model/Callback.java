package com.hujian.coverflowmusic.model;

public interface Callback {

    void onLoaded(Object result);

    void onLoadFailed(String message);

}
