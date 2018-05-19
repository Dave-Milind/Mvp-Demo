package com.milind.myapp;



public interface BasePresenter<T extends BaseView> {

    void setViewer(T obj);
 void onWhichTeamClick();
 void onWhichColorClick();

}
