package com.hujian.coverflowmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.hujian.coverflowmusic.core.net.CHttpClient;
import com.hujian.coverflowmusic.core.net.Callback;
import com.hujian.coverflowmusic.core.net.Request;
import com.hujian.coverflowmusic.core.net.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Request request =new Request.Builder().url("http://192.168.199.186:3000/artist/top/song").build();

        CHttpClient cHttpClient = new CHttpClient.Builder().build();

        cHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) {
                Log.d(TAG, "onResponse: "+response.body().string()+"message||"+response.message()+"||code:"+response.code());
            }

            @Override
            public void onFail(Request request, IOException e) {
                Log.d(TAG, "onFail: request"+request.toString());
            }
        });
    }
}