package com.hujian.coverflowmusic;

import android.util.Log;

import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Callback;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.Response;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final String TAG = "ExampleUnitTest";
    @Test public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void HttpTest(){
        final Request request =new Request.Builder().url("https://www.baidu.com").build();

        CHttpClient cHttpClient = new CHttpClient.Builder().connTimeOut(1).build();

        cHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) {
                Log.d(TAG, "onResponse: "+response.body()+"message||"+response.message()+"||code:"+response.code());
            }

            @Override
            public void onFail(Request request, IOException e) {
                Log.d(TAG, "onFail: request"+request.toString());
            }
        });

    }
}