package com.example.myrxapp.data;

import com.example.myrxapp.POJO.PostsModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
     public static final String BASE_URL="https://jsonplaceholder.typicode.com/";
     private PostInterface postInterface;
     private static PostsClient instance;

     public PostsClient() {
          Retrofit retrofit= new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                  .build();
          postInterface= retrofit.create(PostInterface.class);
     }

     public static PostsClient getInstance() {
          if(instance == null){
               instance= new PostsClient();
          }
          return instance;
     }

     public Single<List<PostsModel>> getPosts(){
          return postInterface.getPosts();
     }
}
