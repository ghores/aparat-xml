package com.example.aparat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.aparat.R;
import com.example.aparat.databinding.ActivityVideoPlayerBinding;
import com.example.aparat.db.AppDatabase;
import com.example.aparat.model.Video;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

public class VideoPlayerActivity extends AppCompatActivity {
    //Binding
    ActivityVideoPlayerBinding binding;
    SimpleExoPlayer player;

    Video video;
    Bundle bundle;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDatabase = AppDatabase.getInstance(getApplicationContext());

        bundle = getIntent().getExtras();
        video = bundle.getParcelable("videoObj");

        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();

        binding.videoPlayer.setPlayer(player);

        MediaItem item = MediaItem.fromUri(video.getLink());
        player.setMediaItem(item);
        player.prepare();
        player.play();

        binding.txtTime.setText(video.getTime());
        binding.txtViews.setText(video.getView());
        binding.txtDescription.setText(video.getDescription());

        if (appDatabase.iDao().isRowIsExist(Integer.parseInt(video.getId()))) {

            binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_24);

        } else {

            binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_border_24);

        }

        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (appDatabase.iDao().isRowIsExist(Integer.parseInt(video.getId()))) {

                    appDatabase.iDao().deleteVideo(Integer.parseInt(video.getId()));
                    binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_border_24);

                } else {

                    binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_24);
                    appDatabase.iDao().insert(video);

                }


            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.stop();
        }
    }
}