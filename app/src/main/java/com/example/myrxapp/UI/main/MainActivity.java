package com.example.myrxapp.UI.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myrxapp.POJO.PostsModel;
import com.example.myrxapp.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    CompositeDisposable compositeDisposable;
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        compositeDisposable= new CompositeDisposable();
//        Disposable disposable= Observable.just("hello World!")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(i-> Log.i(TAG, "onCreate: "+i));
//
//
//        ConnectableObservable<Long> cold = ConnectableObservable.intervalRange(0,5,0,1, TimeUnit.SECONDS).publish();
//        cold.connect();
//        Disposable disposable2=cold.subscribe(i-> Log.i(TAG, "onCreate: "+i));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Disposable disposable3=cold.subscribe(i-> Log.i(TAG, "onCreate2: "+i));
//
//
//        compositeDisposable.add(disposable);
//        compositeDisposable.add(disposable2);
//        compositeDisposable.add(disposable3);

        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
        RecyclerView recyclerView=findViewById(R.id.recycler);
        PostsAdapter adapter= new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        postViewModel.postMutableLiveData.observe(this, adapter::setList);
    }

    @Override
    protected void onDestroy() {
        //compositeDisposable.clear();
        super.onDestroy();
    }
}