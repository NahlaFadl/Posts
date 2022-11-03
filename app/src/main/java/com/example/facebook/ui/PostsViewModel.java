package com.example.facebook.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebook.data.PostClint;
import com.example.facebook.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {

    public MutableLiveData<List<PostsModel>> postsListMutableLiveData=new MutableLiveData<>();

    public void getData(){
        PostClint.getINSTANCE().getPosts().enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {

                postsListMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {

            }
        });
    }
}
