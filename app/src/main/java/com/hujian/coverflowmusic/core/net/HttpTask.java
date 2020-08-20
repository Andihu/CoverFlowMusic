package com.hujian.coverflowmusic.core.net;


import java.io.IOException;

/**
 * Copyright (C), 2015-2020
 * FileName: HttpTask
 * Author: hujian
 * Date: 2020/8/18 16:31
 * History:
 * <author> <time> <version> <desc>
 */
public class HttpTask implements Runnable {

    HttpCall call;

    RequestCallback callback;

    private IRequestHandler requestHandler;

    private IResponseHandler handler = IResponseHandler.RESPONSE_HANDLER;

    public HttpTask(HttpCall call, RequestCallback callback, IRequestHandler requestHandler) {
        this.call = call;
        this.callback = callback;
        this.requestHandler = requestHandler;
    }

    @Override
    public void run() {
        try {
            Response response = requestHandler.handlerRequest(call);
            handler.handlerSuccess(callback, response);
        } catch (IOException e) {
            handler.handFail(callback, call.request, e);
            e.printStackTrace();
        }
    }
}
