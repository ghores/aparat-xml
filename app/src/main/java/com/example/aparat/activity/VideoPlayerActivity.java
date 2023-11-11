package com.example.aparat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aparat.R;
import com.example.aparat.databinding.ActivityVideoPlayerBinding;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();
        video = bundle.getParcelable("videoObj");

        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();

        binding.videoPlayer.setPlayer(player);

        MediaItem item = MediaItem.fromUri(video.getLink());
        player.setMediaItem(item);
        player.prepare();
        player.play();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.stop();
        }
    }
}