package com.milind.myapp.Api;

import com.milind.myapp.MainAct.MainModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts/1")
    Observable<MainModel> getPosts();
}
