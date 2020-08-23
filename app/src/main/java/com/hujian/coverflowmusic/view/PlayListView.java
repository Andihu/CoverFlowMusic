package com.hujian.coverflowmusic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hujian.coverflowmusic.R;
import com.hujian.coverflowmusic.bean.model.Dao.PlayList;
import java.util.List;

public class PlayListView extends FrameLayout {
    private final View view;
    private RecyclerView recyclerView;
    private PlayListAdapter adapter;
    public PlayListView(@NonNull Context context, PlayListAdapter.OnItemClickListener listener) {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.play_list_item_view, this);
        initView();
        setOnItemClickListener(listener);
    }

    public void setOnItemClickListener(PlayListAdapter.OnItemClickListener listener){
        if (adapter!=null){
            adapter.setOnItemClickListener(listener);
        }
    }

    private void initView() {
        adapter = new PlayListAdapter(getContext());
        recyclerView = view.findViewById(R.id.play_list_item);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
    }

    public void bind( List<PlayList> playlistResponse){
        adapter.setPlayListData(playlistResponse);
    }

}
