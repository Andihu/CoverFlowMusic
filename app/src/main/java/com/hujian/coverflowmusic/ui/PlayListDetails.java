package com.hujian.coverflowmusic.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.hujian.coverflowmusic.R;
import com.hujian.coverflowmusic.Utils.GlideRoundTransform;
import com.hujian.coverflowmusic.bean.model.Dao.PlayList;
import com.hujian.coverflowmusic.bean.model.Dao.Song;
import com.hujian.coverflowmusic.bean.songlist.Playlist;
import com.hujian.coverflowmusic.model.IPlayListPresenter;
import com.hujian.coverflowmusic.model.Impl.PlayListPresenterImpl;
import com.hujian.coverflowmusic.view.PlayListDetailsAdapter;
import com.yanzhenjie.sofia.Sofia;

import java.util.List;

public class PlayListDetails extends AppCompatActivity implements IPlayListPresenter.PlayListView{

    private IPlayListPresenter playListPresenter;
    public static final String KEY_PLAYLIST_CREATOR_IMG="KEY_PLAYLIST_CREATOR_IMG";
    public static final String KEY_PLAYLIST_CREATOR_NAME="KEY_PLAYLIST_CREATOR_NAME";
    public static final String KEY_PLAYLIST_NAME="KEY_PLAYLIST_NAME";
    public static final String KEY_PLAYLIST_DESC="KEY_PLAYLIST_DESC";
    public static final String KEY_PLAYLIST_IMG="KEY_PLAYLIST_IMG";
    public static final String KEY_PLAYLIST_ID="KEY_PLAYLIST_ID";
    public static final String KEY_PLAYLIST_COUNT="KEY_PLAYLIST_COUNT";
    public static final String KEY_PLAYLIST_TAG = "KEY_PLAYLIST_TAG";
    private String id;
    private String name;
    private String desc;
    private String imgUrl;
    private String count;
    private String tag;
    private String creatorImg;
    private String creatorName;

    private TextView tvName;
    private TextView tvDesc;
    private TextView tvCount;
    private TextView tvCreatorName;
    private TextView tvTag;

    private ImageView ivBackground;
    private ImageView ivCreatorImg;

    private PlayListDetailsAdapter adapter;

    private RecyclerView recyclerView;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_deatils);
        playListPresenter = new PlayListPresenterImpl(this,this);
        checkData();
        initView();
        playListPresenter.getNetPlayList(Long.parseLong(id));
    }

    private void checkData() {
        Intent intent =this.getIntent();
        if (intent ==null){
           finish();
           return;
       }
        Bundle data = intent.getBundleExtra(MainActivity.KEY_DATA);
        assert data != null;
        id = data.getString(KEY_PLAYLIST_ID);
        name = data.getString(KEY_PLAYLIST_NAME);
        desc = data.getString(KEY_PLAYLIST_DESC);
        imgUrl = data.getString(KEY_PLAYLIST_IMG);
        count = data.getString(KEY_PLAYLIST_COUNT);
        tag = data.getString(KEY_PLAYLIST_TAG);
        creatorImg = data.getString(KEY_PLAYLIST_CREATOR_IMG);
        creatorName = data.getString(KEY_PLAYLIST_CREATOR_NAME);
        if (TextUtils.isEmpty(id)){
            finish();
        }
    }

    private void initView() {
        adapter= new PlayListDetailsAdapter(this);
        recyclerView = findViewById(R.id.play_detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        view = LayoutInflater.from(this).inflate(R.layout.playlist_detaild_header,recyclerView,false);
        ivBackground = view.findViewById(R.id.song_detail_bg);
        ivCreatorImg = view.findViewById(R.id.song_detail_creator_img);
        tvName = view.findViewById(R.id.song_detail_name);
        tvDesc = view.findViewById(R.id.song_detail_desc);
        tvCreatorName = view.findViewById(R.id.song_detail_creator_name);
        tvTag = view.findViewById(R.id.song_detail_tag);
        ivBackground.setScaleType(ImageView.ScaleType.CENTER);
        adapter.setHeaderView(view);
        adapter.setBindHeadView(new PlayListDetailsAdapter.OnBindHeadView() {
            @Override
            public void bind(View view) {
                Glide.with(PlayListDetails.this)
                        .asBitmap()
                        .load(imgUrl)
                        .centerCrop()
                        .into(new CustomTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                                ivBackground.setImageBitmap(resource);
                                Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                                    @Override
                                    public void onGenerated(Palette palette) {
                                        //记得判空
                                        if(palette==null)return;
                                        recyclerView.setBackgroundColor(palette.getMutedColor(Color.TRANSPARENT));
                                    }
                                });
                            }
                            @Override
                            public void onLoadCleared(@Nullable Drawable placeholder) {}
                        });
                Glide.with(PlayListDetails.this)
                        .load(creatorImg)
                        .into(ivCreatorImg);
                tvName.setText(name);
                tvDesc.setText(desc);
                tvCreatorName.setText(creatorName);
                tvTag.setText(tag);
            }
        });
    }



    @Override
    public void onLoadSuccess(Playlist result) {
        List<Song> songs = Song.toSongsFromPlayList(result);
        adapter.setData(songs);
    }

    @Override
    public void onLoadFailed(String message) {

    }

}