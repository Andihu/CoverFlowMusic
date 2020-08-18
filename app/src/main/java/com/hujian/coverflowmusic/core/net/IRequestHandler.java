package com.hujian.coverflowmusic.core.net;

import java.io.IOException;

/**
 * Copyright (C), 2015-2020
 * FileName: IRequestHandler
 * Author: hujian
 * Date: 2020/8/18 16:34
 * History:
 * <author> <time> <version> <desc>
 */
public interface  IRequestHandler {
    /**
     * 处理请求
     *
     * @param call 　一次请求发起
     * @return 应答
     * @throws IOException 　网络连接或者其它异常
     */
    Response handlerRequest(HttpCall call) throws IOException;
}
