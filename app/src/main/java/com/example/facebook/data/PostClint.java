package com.example.facebook.data;

import com.example.facebook.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClint {

    private static PostClint INSTANCE;
    private API api;
    private static String URL="https://jsonplaceholder.typicode.com/";

    public PostClint() {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api=retrofit.create(API.class);
    }

    public static PostClint getINSTANCE() {
        if (null==INSTANCE){
            INSTANCE=new PostClint();
        }
        return INSTANCE;
    }

    public Call<List<PostsModel>> getPosts(){
        return api.getPosts();
    }
}
