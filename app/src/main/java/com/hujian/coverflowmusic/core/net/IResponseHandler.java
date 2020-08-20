package com.hujian.coverflowmusic.core.net;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

/**
 * Copyright (C), 2015-2020
 * FileName: IResponseHandler
 * Author: hujian
 * Date: 2020/8/18 16:34
 * History:
 * <author> <time> <version> <desc>
 */
public interface IResponseHandler {
    /**
     * 线程切换,http请求成功时的回调
     *
     * @param callback 　回调接口
     * @param response 　返回结果
     */
    void handlerSuccess(RequestCallback callback, Response response);

    /**
     * 线程切换,http请求失败时候的回调
     *
     * @param callback 　回调接口
     * @param request  　请求
     * @param e        　可能产生的异常
     */
    void handFail(RequestCallback callback, Request request, IOException e);


    IResponseHandler RESPONSE_HANDLER = new IResponseHandler() {

        Handler HANDLER = new Handler(Looper.getMainLooper());

        @Override
        public void handlerSuccess(final RequestCallback callback, final Response response) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    callback.onResponse(response);
                }
            };
            execute(runnable);
        }

        @Override
        public void handFail(final RequestCallback callback, final Request request, final IOException e) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    callback.onFail(request,e);
                }
            };
            execute(runnable);
        }


        /**
         * 移除所有消息
         */
        public void removeAllMessage() {
            HANDLER.removeCallbacksAndMessages(null);
        }

        /**
         * 线程切换
         * @param runnable
         */
        private void execute(Runnable runnable) {
            HANDLER.post(runnable);
        }

    };

}
