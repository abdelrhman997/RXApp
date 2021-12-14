package com.example.myrxapp.UI.main;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myrxapp.POJO.PostsModel;
import com.example.myrxapp.data.PostsClient;
import java.util.List;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class PostViewModel extends ViewModel {
    private static final String TAG = PostViewModel.class.getSimpleName();
    MutableLiveData<List<PostsModel>> postMutableLiveData= new MutableLiveData<>();
    public void getPosts(){

//        PostsClient.getInstance().getPosts().enqueue(new Callback<List<PostsModel>>() {
//            @Override
//            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
//                postMutableLiveData.postValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
//            }
//        });
         Single<List<PostsModel>> observable =PostsClient.getInstance().getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//        Observer<List<PostsModel>> observer= new Observer<List<PostsModel>>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull List<PostsModel> postsModels) {
//
//                postMutableLiveData.postValue(postsModels);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };

//        observable.subscribe(observer);
        observable.subscribe(o->postMutableLiveData.postValue(o),e-> Log.d(TAG, "getPosts: "+e.getMessage()));

    }
}
