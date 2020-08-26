package com.hujian.coverflowmusic.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.hujian.coverflowmusic.R;
import com.hujian.coverflowmusic.Service.MusicService;
import com.hujian.coverflowmusic.Service.MusicServiceImpl;
import com.hujian.coverflowmusic.bean.model.Dao.Song;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayActivity extends AppCompatActivity {

    private ArrayList<Song> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
    }

    private ServiceConnection musicConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicServiceImpl.ServiceBinder binder = (MusicServiceImpl.ServiceBinder) iBinder;
            MusicServiceImpl service = binder.getService();
            service.setList(songList);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

}