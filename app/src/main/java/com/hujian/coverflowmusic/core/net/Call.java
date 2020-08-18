package com.hujian.coverflowmusic.core.net;

/**
 * Copyright (C), 2015-2020
 * FileName: Call
 * Author: hujian
 * Date: 2020/8/18 16:25
 * History:
 * <author> <time> <version> <desc>
 */
public interface Call {
    /**
     * 同步执行
     *
     * @return response
     */
    Response execute();

    /**
     * 异步执行
     *
     * @param callback 回调接口
     */
    void enqueue(Callback callback);
}
