package com.example.aparat.api;

import com.example.aparat.model.News;
import com.example.aparat.model.Video;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {

    @GET("getBestVideos.php")
    Call<List<Video>> getBestVideos();

    @GET("getNewVideos.php")
    Call<List<Video>> getNewVideos();

    @GET("getSpecial.php")
    Call<List<News>> getSpecialVideos();

    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String user, @Field("password") String pass);

    @POST("register.php")
    Call<ResponseBody> register(@Field("username") String user, @Field("password") String pass);

}
