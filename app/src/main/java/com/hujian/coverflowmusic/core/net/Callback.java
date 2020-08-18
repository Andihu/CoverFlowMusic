package com.hujian.coverflowmusic.core.net;

import java.io.IOException;

/**
 * Copyright (C), 2015-2020
 * FileName: Callback
 * Author: hujian
 * Date: 2020/8/18 16:17
 * History:
 * <author> <time> <version> <desc>
 */
public interface Callback {

    /**
     * 成功获取结果
     * @param response
     */
    void onResponse(Response response);

    /**
     * 返回结果失败
     * @param request
     * @throws IOException
     */
    void onFail(Request request,IOException e);
}
