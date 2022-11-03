package com.example.facebook.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.R;
import com.example.facebook.pojo.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    List<PostsModel> postsModels=new ArrayList<>();
    @NonNull
    @Override
    public PostsAdapter.PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostsViewHolder holder, int position) {

        holder.txtUserId.setText(postsModels.get(position).getUserId()+"");
        holder.txtTitle.setText(postsModels.get(position).getTitle());
        holder.txtBoy.setText(postsModels.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsModels.size();
    }

    public void setList(List<PostsModel> postsModels){

        this.postsModels=postsModels;
        notifyDataSetChanged();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtUserId, txtBoy;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle=itemView.findViewById(R.id.txtTitlle);
            txtUserId=itemView.findViewById(R.id.txtUserId);
            txtBoy=itemView.findViewById(R.id.txtBody);
        }
    }
}
