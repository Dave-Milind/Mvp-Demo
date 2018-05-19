package com.milind.myapp.MainAct;

import com.milind.myapp.Api.ApiInterface;

import dagger.Component;

@Component (modules = MainModule.class)
public interface MainComponent {
    ApiInterface getApiservice();
}
