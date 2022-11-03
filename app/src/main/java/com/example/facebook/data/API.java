package com.example.facebook.data;



import com.example.facebook.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("posts")
    public Call<List<PostsModel>> getPosts();
}
