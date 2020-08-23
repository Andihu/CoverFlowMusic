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
import com.hujian.coverflowmusic.bean.model.Dao.Song;

import java.util.ArrayList;
import java.util.List;

public class PlayListDetailsAdapter extends RecyclerView.Adapter {

    public static final int TYPE_HEADER = 0; //说明是带有Header的

    public static final int TYPE_NORMAL = 2; //说明是不带有header和footer的

    private Context mContext;

    //HeaderView
    private View mHeaderView;

    public List<Song> data = new ArrayList<>();

    private OnBindHeadView bindHeadView;

    public void setBindHeadView(OnBindHeadView bindHeadView) {
        this.bindHeadView = bindHeadView;
    }

    public interface OnBindHeadView{
       void bind(View view);
    }

    public PlayListDetailsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Song> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType==TYPE_NORMAL){
            return new SongHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hotsong_list_item_view, parent, false));
        }else {
            return new SongHolder(mHeaderView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_NORMAL){
        SongHolder hotSongHolder = (SongHolder) holder;
        Song song = data.get(position);
        hotSongHolder.musicDesc.setText(song.getAlbumName());
        hotSongHolder.musicName.setText(song.getName());
        Glide.with(mContext)
                .load(song.getAlbumPic())
                .apply(new RequestOptions().transform(new GlideRoundTransform(mContext, 10)))
                .into(hotSongHolder.musicIcon);
        }else if (getItemViewType(position)==TYPE_HEADER){
            if (bindHeadView!=null){
                bindHeadView.bind(mHeaderView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && mHeaderView!=null){
            //第一个item应该加载Header
            return TYPE_HEADER;
        }
        return TYPE_NORMAL;
    }

    class SongHolder extends RecyclerView.ViewHolder {
        private ImageView musicIcon;
        private TextView musicName;
        private TextView musicDesc;

        public SongHolder(@NonNull View itemView) {
            super(itemView);
            if (itemView == mHeaderView ){
                return;
            }
            musicDesc = itemView.findViewById(R.id.hot_song_desc);
            musicName = itemView.findViewById(R.id.hot_song_name);
            musicIcon = itemView.findViewById(R.id.hot_song_img);
        }
    }
}
