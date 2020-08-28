package com.hujian.coverflowmusic.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.hujian.coverflowmusic.R;
import com.hujian.coverflowmusic.Service.MusicServiceImpl;
import com.hujian.coverflowmusic.bean.model.Dao.Song;
import com.hujian.coverflowmusic.bean.song.Songs;
import com.hujian.coverflowmusic.model.ISongPresenter;
import com.hujian.coverflowmusic.model.Impl.SongDetailsImpl;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayActivity extends AppCompatActivity implements ISongPresenter.SongView , View.OnClickListener {

    private ArrayList<Song> songList = new ArrayList<>();

    private ImageView vTitleDown;
    private ImageView vTitlePlayList;
    private ImageView vAlbumAvatar;
    private ImageView vPlayMode;
    private ImageView vPlayPre;
    private ImageView vPlayNext;
    private ImageView vPlay;
    private ImageView vFavorite;
    private SeekBar vSoundProgress;
    private SeekBar vSongProgress;

    private MusicServiceImpl musicService;
    private ISongPresenter songPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        initData();
        initView();
        songPresenter = new SongDetailsImpl(this,this);
    }

    private void initData() {

    }

    private void initView() {
        vTitleDown = findViewById(R.id.titlebar_down);
        vTitlePlayList = findViewById(R.id.titlebar_play_list);
        vAlbumAvatar = findViewById(R.id.playing_song_album);
        vPlayMode = findViewById(R.id.music_player_mode);
        vPlayPre = findViewById(R.id.music_player_pre);
        vPlayNext = findViewById(R.id.music_player_next);
        vPlay = findViewById(R.id.music_play);
        vFavorite = findViewById(R.id.iv_favorite_music);
        vSoundProgress = findViewById(R.id.sb_volume);
        vSongProgress = findViewById(R.id.sb_progress);
    }

    private ServiceConnection musicConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicServiceImpl.ServiceBinder binder = (MusicServiceImpl.ServiceBinder) iBinder;
            musicService = binder.getService();
            musicService.setList(songList);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {}
    };

    @Override
    public void onLoadSuccess(List<Songs> result) {

    }

    @Override
    public void onLoadFailed(String message) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.titlebar_down:
                // TODO: 2020/8/28 菜单
                break;
            case R.id.titlebar_play_list:
                // TODO: 2020/8/28 播放列表
                break;
            case R.id.playing_song_album:
                // TODO: 2020/8/28 专辑头像
                break;
            case R.id.music_player_mode:
                // TODO: 2020/8/28 播放模式
                break;
            case R.id.music_player_pre:
                // TODO: 2020/8/28 上一首
                break;
            case R.id.music_play:
                // TODO: 2020/8/28 播放/暂停
                break;
            case R.id.music_player_next:
                // TODO: 2020/8/28 下一首
                break;
            case R.id.iv_favorite_music:
                // TODO: 2020/8/28 收藏
                break;

        }
    }
}