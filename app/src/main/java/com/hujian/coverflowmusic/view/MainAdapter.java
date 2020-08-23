package com.hujian.coverflowmusic.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hujian.coverflowmusic.R;
import com.hujian.coverflowmusic.Utils.GlideRoundTransform;
import com.hujian.coverflowmusic.bean.model.Dao.PlayList;
import com.hujian.coverflowmusic.bean.model.Dao.Song;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    private static final int TYPE_TIP = 0;
    private static final int TYPE_HOT_SONG = 1;
    private static final int TYPE_PLAY_LIST = 2;

    private PlayListData playListData;
    private List<Song> hotSongData = new ArrayList<>();
    public List<Object> data = new ArrayList<>();

    private Context mContext;

    private PlayListAdapter.OnItemClickListener playListClickListener;

    private OnMusicClickListener musicClickListener;

    public void setMusicClickListener(OnMusicClickListener musicClickListener) {
        this.musicClickListener = musicClickListener;
    }

    public void setPlayListClickListener(PlayListAdapter.OnItemClickListener playListClickListener) {
        this.playListClickListener = playListClickListener;
    }

    public MainAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setHotSongData(List<Song> hotSongData) {
        this.hotSongData = hotSongData;
        if (data.size() > 0) {
            data.add(2, new TipView("新歌速递"));
            data.addAll(3, hotSongData);
        } else {
            data.add(new TipView("新歌速递"));
            data.addAll(hotSongData);
            notifyDataSetChanged();
        }
        notifyDataSetChanged();
    }

    public void setPlayListData(List<PlayList> playListData) {
        this.playListData = new PlayListData(playListData);
        data.add(0, new TipView("热门歌单"));
        data.add(1, this.playListData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case TYPE_TIP:
                return new TipHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_tip_view, null));
            case TYPE_PLAY_LIST:
                return new PlayListHolder(new PlayListView(parent.getContext(),playListClickListener));
            case TYPE_HOT_SONG:
                return new HotSongHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hotsong_list_item_view, parent, false));
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case TYPE_TIP:
                ((TipHolder) holder).tip.setText(((TipView) data.get(position)).getMessage());
                break;
            case TYPE_HOT_SONG:
                HotSongHolder hotSongHolder = (HotSongHolder) holder;
                Song song = (Song) data.get(position);
                hotSongHolder.musicDesc.setText(song.getAlbumName());
                hotSongHolder.musicName.setText(song.getName());
                Glide.with(mContext)
                        .load(song.getAlbumPic())
                        .apply(new RequestOptions().transform(new GlideRoundTransform(mContext, 10)))
                        .into(hotSongHolder.musicIcon);
                break;
            case TYPE_PLAY_LIST:
                PlayListHolder playListHolder = (PlayListHolder) holder;
                PlayListData data = (PlayListData) this.data.get(position);
                playListHolder.bind(data.getPlayListData());
                break;
            default:
                break;
        }

        if (getItemViewType(position)==TYPE_HOT_SONG){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (musicClickListener!=null){
                        musicClickListener.onClick((Song) data.get(position));
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof TipView) {
            return TYPE_TIP;
        } else if (data.get(position) instanceof Song) {
            return TYPE_HOT_SONG;
        } else if (data.get(position) instanceof PlayListData) {
            return TYPE_PLAY_LIST;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnMusicClickListener{
        void onClick(Song song);
    }

    static class TipView {
        String message;

        public TipView(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    static class PlayListData {
        private List<PlayList> playListData;

        public PlayListData(List<PlayList> playListData) {
            this.playListData = playListData;
        }

        public List<PlayList> getPlayListData() {
            return playListData;
        }
    }


    static class TipHolder extends RecyclerView.ViewHolder {
        private TextView tip;

        public TipHolder(@NonNull View itemView) {
            super(itemView);
            tip = itemView.findViewById(R.id.tip);
        }
    }

    static class HotSongHolder extends RecyclerView.ViewHolder {
        private ImageView musicIcon;
        private TextView musicName;
        private TextView musicDesc;

        public HotSongHolder(@NonNull View itemView) {
            super(itemView);
            musicDesc = itemView.findViewById(R.id.hot_song_desc);
            musicName = itemView.findViewById(R.id.hot_song_name);
            musicIcon = itemView.findViewById(R.id.hot_song_img);
        }
    }

    static class PlayListHolder extends RecyclerView.ViewHolder {
        private PlayListView playListView;

        public PlayListHolder(@NonNull View itemView) {
            super(itemView);
            playListView = (PlayListView) itemView;
        }

        public void bind(List<PlayList> response) {
            playListView.bind(response);
        }
    }

}
