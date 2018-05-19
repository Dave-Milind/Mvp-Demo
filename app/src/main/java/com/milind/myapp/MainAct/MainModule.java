package com.milind.myapp.MainAct;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.milind.myapp.Api.ApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainModule {

    Context context;
    MainModule(MainActivity mainActivity){

        this.context=mainActivity;

    }

    @Provides
    Context provideContext(){

        return context;
    }
    @Provides
    Retrofit provideRetrofit(){

       return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    ApiInterface provideApiInterface(Retrofit retrofit){

        return retrofit.create(ApiInterface.class);
    }

}
