package com.example.sakkawy.rxjavaretrofitsample.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sakkawy.rxjavaretrofitsample.R;
import com.example.sakkawy.rxjavaretrofitsample.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    Context context;
    List<Post> postList ;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.custom_layout,parent,false
                );
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.auther.setText(String.valueOf(postList.get(position).getUserId()));
        holder.title.setText(String.valueOf(postList.get(position).getTitle()));
        holder.content.setText(new StringBuilder(postList.get(position).getBody().substring(0,20))
                .append("...").toString());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
