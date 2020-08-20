package com.hujian.coverflowmusic.core.net;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Copyright (C), 2015-2020
 * FileName: HttpCall
 * Author: hujian
 * Date: 2020/8/18 16:29
 * History:
 * <author> <time> <version> <desc>
 */
public class HttpCall implements Call {

    final Request request;

    final CHttpClient.Config config;

    private static IRequestHandler requestHandler = new RequestHandler();


    public HttpCall(CHttpClient.Config config, Request request) {
        this.config = config;
        this.request = request;
    }


    @Override
    public Response execute() {
        Callable<Response> task = new SyncTask();
        Response response;
        try {
            response = HttpThreadPool.getInstance().submit(task);
            return response;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Response.Builder()
                .code(400)
                .message("线程异常中断")
                .body(new ResponseBody(null))
                .build();

    }

    @Override
    public void enqueue(RequestCallback callback) {
        Runnable runnable = new HttpTask(this, callback, requestHandler);
        HttpThreadPool.getInstance().execute(new FutureTask<>(runnable, null));
    }

    /**
     * 同步提交Callable
     */
    class SyncTask implements Callable<Response> {
        @Override
        public Response call() throws Exception {
            Response response = requestHandler.handlerRequest(HttpCall.this);
            return response;
        }
    }
}
