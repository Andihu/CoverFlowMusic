package com.hujian.coverflowmusic.Service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;

import androidx.annotation.Nullable;

import com.hujian.coverflowmusic.bean.model.Dao.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MusicServiceImpl extends Service implements MusicService ,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener{

    private final IBinder mBinder =new ServiceBinder() ;

    private MediaPlayer mediaPlayer;

    //song list
    private ArrayList<Song> songs;

    private boolean shuffle=false;

    //current position
    private int songPos;

    private Random rand;


    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }


    public class ServiceBinder extends Binder{
       public MusicServiceImpl getService(){
            return MusicServiceImpl.this;
        }
    }

    public void initMusicPlay(){
        //set player properties
        mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //set listeners
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        songPos = 0;
        mediaPlayer = new MediaPlayer();
        rand = new Random();
        initMusicPlay();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        mediaPlayer.reset();
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        //check if playback has reached the end of a track
        if (this.mediaPlayer.getCurrentPosition() > 0) {
            mediaPlayer.reset();
            next();
        }
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public void seekTo(int position) {
        mediaPlayer.seekTo(position);
    }
    public void setList(ArrayList<Song> songs){
        this.songs = songs;
    }

    public void setSong(int songIndex){
        songPos = songIndex;
    }

    @Override
    public void play() {
        mediaPlayer.reset();
        Song song = songs.get(songPos);
        try {
            mediaPlayer.setDataSource(song.getPlayUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.prepareAsync();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public String next() {
        if (shuffle) {
            int newSong = songPos;
            while (newSong == songPos) {
                newSong = rand.nextInt(songs.size());
            }
            songPos = newSong;
        } else {
            songPos++;
            if (songPos >= songs.size()) songPos = 0;
        }
        play();
        return null;
    }

    @Override
    public String previous() {
        songPos--;
        if (songPos<0) songPos = songs.size()-1;
        play();
        return songs.get(songPos).getName();
    }
    //toggle shuffle
    public void setShuffle(){
        if(shuffle) shuffle=false;
        else shuffle=true;
    }
}
