package com.hujian.coverflowmusic.model;

import com.hujian.coverflowmusic.bean.lrc.Lrc;

public interface ILrcPresenter {

    void getLrc(int id);

    void getLocalLrc(int id);

    void saveLocalLrc(Lrc lrc);

    void removeLocalLrc();

    interface LrcView{

        void loadSuccess(String lrc);

        void loadFailed(String message);
    }

}
