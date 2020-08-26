package com.hujian.coverflowmusic.Service;

public interface MusicService {

    int getCurrentPosition();

    int getDuration();

    void seekTo(int position);

    void play();

    void pause();

    String next();

    String previous();



}
