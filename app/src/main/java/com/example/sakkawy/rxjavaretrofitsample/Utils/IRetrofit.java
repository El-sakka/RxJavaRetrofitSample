package com.example.sakkawy.rxjavaretrofitsample.Utils;

import com.example.sakkawy.rxjavaretrofitsample.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IRetrofit {
    @GET("posts")
    Observable<List<Post>> getPosts();
}
