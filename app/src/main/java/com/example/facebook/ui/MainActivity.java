package com.example.facebook.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebook.R;
import com.example.facebook.pojo.PostsModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsViewModel=new ViewModelProvider(this).get(PostsViewModel.class);
        postsViewModel.getData();

        RecyclerView recyclerView=findViewById(R.id.recycler);
        PostsAdapter postsAdapter=new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postsAdapter);

        postsViewModel.postsListMutableLiveData.observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {

                postsAdapter.setList(postsModels);
            }
        });
    }
}