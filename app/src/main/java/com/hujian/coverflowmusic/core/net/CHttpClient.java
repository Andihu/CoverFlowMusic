package com.hujian.coverflowmusic.core.net;

import android.telecom.Call;

/**
 * Copyright (C), 2015-2020
 * FileName: CHttpClient
 * Author: hujian
 * Date: 2020/8/18 16:20
 * History:
 * <author> <time> <version> <desc>
 */
public class CHttpClient {

    private Config config;

    public CHttpClient(Builder builder) {
        this.config = new Config(builder);
    }


    public HttpCall newCall(Request request) {
        return new HttpCall(config, request);
    }

    public static class Config {
        final int connTimeout;
        final int readTimeout;
        final int writeTimeout;

        public Config(Builder builder) {
            this.connTimeout = builder.connTimeout;
            this.readTimeout = builder.connTimeout;
            this.writeTimeout = builder.writeTimeout;
        }
    }

    public static final class Builder{
        private int connTimeout;
        private int readTimeout;
        private int writeTimeout;

        public Builder() {
            this.connTimeout = 10 * 1000;
            this.readTimeout = 30 * 1000;
            this.writeTimeout = 30 * 1000;
        }

        public Builder readTimeOut(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder connTimeOut(int connTimeout) {
            this.connTimeout = connTimeout;
            return this;
        }

        public Builder writeTimeOut(int writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }

        public CHttpClient build() {
            return new CHttpClient(this);
        }
    }
}
