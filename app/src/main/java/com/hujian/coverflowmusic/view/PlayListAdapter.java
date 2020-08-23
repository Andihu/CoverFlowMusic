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

import java.util.ArrayList;
import java.util.List;



public class PlayListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PlayList> playListData = new ArrayList<>();

    private Context mContext;

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PlayListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setPlayListData(List<PlayList> playListData) {
        this.playListData = playListData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.song_list_item_view, parent, false);
        return new PlayListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        PlayListHolder playListHolder = (PlayListHolder) holder;
        Glide.with(mContext)
                .load(playListData.get(position).getCoverImageUrl())
                .apply(new RequestOptions().transform(new GlideRoundTransform(mContext, 10)))
                .into(playListHolder.coverImg);
        Glide.with(mContext)
                .load(playListData.get(position).getCreatorAvatar())
                .into(playListHolder.avatarImg);
        playListHolder.avatarName.setText(playListData.get(position).getCreatorName());
        playListHolder.playListName.setText(playListData.get(position).getName());
        playListHolder.playListTag.setText(playListData.get(position).getTag());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(playListData.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return playListData.size();
    }

    static class PlayListHolder extends RecyclerView.ViewHolder {
        private ImageView coverImg;
        private ImageView avatarImg;
        private TextView playListName;
        private TextView playListTag;
        private TextView avatarName;

        public PlayListHolder(@NonNull View itemView) {
            super(itemView);
            coverImg = itemView.findViewById(R.id.play_list_bg);
            avatarImg = itemView.findViewById(R.id.creator_avatar);
            playListName = itemView.findViewById(R.id.play_list_name);
            playListTag = itemView.findViewById(R.id.play_list_tag);
            avatarName = itemView.findViewById(R.id.creator_name);
        }
    }

    public interface OnItemClickListener {
        void onClick(PlayList playList);
    }
}
