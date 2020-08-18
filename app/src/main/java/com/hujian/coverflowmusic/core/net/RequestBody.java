package com.hujian.coverflowmusic.core.net;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Copyright (C), 2015-2020
 * FileName: RequestBody
 * Author: hujian
 * Date: 2020/8/18 15:45
 * History:
 * <author> <time> <version> <desc>
 */
public abstract class RequestBody {

    /**
     * body 类型
     * @return
     */

    abstract String contentType();

    /**
     * 写入内容
     * @param outputStream
     * @throws IOException
     */
    abstract void writeTo(OutputStream outputStream) throws IOException;

}
