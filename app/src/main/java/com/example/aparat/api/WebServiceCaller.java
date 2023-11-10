package com.example.aparat.api;

import android.util.Log;

import com.example.aparat.model.IResponseListener;
import com.example.aparat.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceCaller {

    IService iService;

    public WebServiceCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);
    }

    public void getBestVideos(IResponseListener listener) {
        Call<List<Video>> bestVideos = iService.getBestVideos();

        bestVideos.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage());
            }
        });
    }

    public void getNewVideos(IResponseListener listener) {
        Call<List<Video>> bestVideos = iService.getNewVideos();

        bestVideos.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage());
            }
        });
    }
}
