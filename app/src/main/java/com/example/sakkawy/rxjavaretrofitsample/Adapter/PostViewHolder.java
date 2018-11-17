package com.example.sakkawy.rxjavaretrofitsample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sakkawy.rxjavaretrofitsample.R;

public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView title,content,auther;
    public PostViewHolder(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        content = itemView.findViewById(R.id.content);
        auther = itemView.findViewById(R.id.author);
    }
}
