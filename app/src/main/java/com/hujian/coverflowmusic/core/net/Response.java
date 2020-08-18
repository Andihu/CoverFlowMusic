package com.hujian.coverflowmusic.core.net;

/**
 * Copyright (C), 2015-2020
 * FileName: Reponse
 * Author: hujian
 * Date: 2020/8/18 16:14
 * History:
 * <author> <time> <version> <desc>
 */
public class Response {

    final ResponseBody body;

    final String message;

    final int code;

    public Response(Builder builder) {
        this.body = builder.body;
        this.message = builder.message;
        this.code = builder.code;
    }

    public ResponseBody body() {
        return this.body;
    }
    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    static class Builder{
        private ResponseBody body;
        private String message;
        private int code;

        public Builder body(ResponseBody body) {
            this.body = body;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Response build() {
            if (message == null) throw new NullPointerException("response message == null");
            if (body == null) throw new NullPointerException("response body == null");
            return new Response(this);
        }
    }
}
