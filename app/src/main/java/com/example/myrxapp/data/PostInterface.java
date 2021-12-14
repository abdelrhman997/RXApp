package com.example.myrxapp.data;

import com.example.myrxapp.POJO.PostsModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    Single<List<PostsModel>> getPosts();
}
