package com.example.aparat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aparat.R;
import com.example.aparat.activity.VideoPlayerActivity;
import com.example.aparat.model.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

    Context context;
    List<Video> videoList;

    public VideoAdapter(Context context, List<Video> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.video_row, null);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {

        Video video = videoList.get(position);
        holder.txt_title.setText(video.getTitle());
        Picasso.get().load(video.getIcon()).into(holder.img_icon);

        holder.linear_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VideoPlayerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("videoObj", video);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class VideoHolder extends RecyclerView.ViewHolder {
        AppCompatImageView img_icon;
        AppCompatTextView txt_title;
        LinearLayout linear_video;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            img_icon = itemView.findViewById(R.id.img_icon);
            txt_title = itemView.findViewById(R.id.txt_title);
            linear_video = itemView.findViewById(R.id.linear_video);
        }
    }
}
