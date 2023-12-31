package com.example.aparat.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.R;
import com.example.aparat.adapter.NewsAdapter;
import com.example.aparat.adapter.VideoAdapter;
import com.example.aparat.api.WebServiceCaller;
import com.example.aparat.model.IResponseListener;
import com.example.aparat.model.News;
import com.example.aparat.model.Video;

import java.util.List;

public class HomeFragment extends Fragment {

    WebServiceCaller webServiceCaller;
    RecyclerView recycler_best_video, recycler_new_video,recycler_special_video;
    ViewPager news_pager;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recycler_best_video = view.findViewById(R.id.recycler_best_video);
        recycler_new_video = view.findViewById(R.id.recycler_new_video);
        news_pager = view.findViewById(R.id.news_pager);
        recycler_special_video = view.findViewById(R.id.recycler_special_video);

        webServiceCaller = new WebServiceCaller();
        webServiceCaller.getBestVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("", "");
                recycler_best_video.setAdapter(new VideoAdapter(getActivity(), (List<Video>) responseMessage));
                recycler_best_video.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("", "");

            }
        });

        webServiceCaller.getNewVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("", "");
                recycler_new_video.setAdapter(new VideoAdapter(getActivity(), (List<Video>) responseMessage));
                recycler_new_video.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("", "");

            }
        });

        webServiceCaller.getNewsVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                List<News> newsList = (List<News>) responseMessage;


                NewsAdapter adapter= new NewsAdapter(getActivity() , newsList);
                news_pager.setAdapter(adapter);



            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });


        webServiceCaller.getSpecialVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                recycler_special_video.setAdapter(new VideoAdapter(getActivity(), (List<Video>) responseMessage));
                recycler_special_video.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        return view;
    }
}