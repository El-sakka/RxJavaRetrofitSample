package com.example.sakkawy.rxjavaretrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sakkawy.rxjavaretrofitsample.Adapter.PostAdapter;
import com.example.sakkawy.rxjavaretrofitsample.Utils.IRetrofit;
import com.example.sakkawy.rxjavaretrofitsample.Utils.RetrofitClient;
import com.example.sakkawy.rxjavaretrofitsample.model.Post;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IRetrofit iRetrofit;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = RetrofitClient.getInstance();
        iRetrofit = retrofit.create(IRetrofit.class);

        // view
        recyclerView = findViewById(R.id.posts_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(
            iRetrofit.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {
                        displayData(posts);
                    }
                })
        );
    }

    private void displayData(List<Post> posts) {
        PostAdapter adapter = new PostAdapter(this,posts);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}
