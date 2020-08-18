package com.hujian.coverflowmusic.core.net;

import java.io.UnsupportedEncodingException;

/**
 * Copyright (C), 2015-2020
 * FileName: Response
 * Author: hujian
 * Date: 2020/8/18 16:12
 * History:
 * <author> <time> <version> <desc>
 */
public class ResponseBody {

    byte[] bytes;

    public ResponseBody(byte[] bytes) {
        this.bytes = bytes;
    }
    public byte[] bytes() {
        return this.bytes;
    }
    public String string() {
        try {
            return new String(bytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
