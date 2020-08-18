package com.hujian.coverflowmusic.core.net;

import android.text.TextUtils;
import android.util.ArrayMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2015-2020
 * FileName: Request
 * Author: hujian
 * Date: 2020/8/18 15:47
 * History:
 * <author> <time> <version> <desc>
 */
public class Request {

     HttpMethod method;

     String url;

     Map<String, String> heads;

     RequestBody body;

    public Request(Builder builder) {
        this.method = builder.method;
        this.url = builder.url;
        this.heads = builder.heads;
        this.body = builder.body;
    }

    public static class Builder {
        HttpMethod method;
        String url;
        HashMap<String, String> heads;
        RequestBody body;

        public Builder() {
            this.method = HttpMethod.GET;
            this.heads = new HashMap<String, String>();
        }

        public Builder(Request request) {
            this.body = body;
            this.url = request.url;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder header(String name, String value) {
            heads.put(name, value);
            return this;
        }

        public Builder get() {
            method(HttpMethod.GET, null);
            return this;
        }

        public Builder post(RequestBody body) {
            method(HttpMethod.POST, body);
            return this;
        }

        public Builder put(RequestBody body) {
            method(HttpMethod.PUT, body);
            return this;
        }

        public Builder delete(RequestBody body) {
            method(HttpMethod.DELETE, body);
            return this;
        }

        public Builder method(HttpMethod method, RequestBody body) {
            this.method = method;
            this.body = body;
            return this;
        }

        public Request build() {
            if (url == null) {
                throw new IllegalStateException("访问url不能为空");
            }
            if (body != null) {
                if (!TextUtils.isEmpty(body.contentType())) {
                    heads.put("Content-Type", body.contentType());
                }
            }
            heads.put("Connection", "Keep-Alive");
            heads.put("Charset", "UTF-8");
            return new Request(this);
        }
    }

    public enum HttpMethod {
        GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

        private String method;

        HttpMethod(String methodValue) {
            this.method = methodValue;
        }

        public static boolean checkNeedBody(HttpMethod method) {
            return POST.equals(method) || PUT.equals(method);
        }

        public static boolean checkNoBody(HttpMethod method) {
            return GET.equals(method) || DELETE.equals(method);
        }
    }

    @Override public String toString() {
        return "Request{" + "method=" + method + ", url='" + url + '\'' + ", heads=" + heads + ", body=" + body + '}';
    }
}
