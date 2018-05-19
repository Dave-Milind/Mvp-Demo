package com.milind.myapp.MainAct;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.milind.myapp.MainAct.MainContract;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter implements MainContract.Presenter {
    MainContract.View mView;


    @Override
    public void setViewer(MainContract.View obj) {

        this.mView = obj;
    }

    @Override
    public void onWhichTeamClick() {

        mView.whichTeam("Golden State Warriors");
    }

    @Override
    public void onWhichColorClick() {
        mView.whichColor("White");
    }

    //simple business logic i have created here in the following method
    @Override
    public void onWildcardClick() {
        if (mView.isItAWildCard()) {

            Toast.makeText((Context) mView, "It is wildcard", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText((Context) mView, "It is not a wildcard", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onApiCallClick(){


        Observable<MainModel>observable= MainActivity.mainComponent.getApiservice().getPosts();
              observable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<MainModel>() {
              @Override
              public void onSubscribe(Disposable d) {

              }

              @Override
              public void onNext(MainModel mainModel) {

                  Log.e("TAG", "title: " + mainModel.getTitle() + " id: " + mainModel.getId());
                  mView.getData("The data from api:"+" id: " + mainModel.getId()+" title: " + mainModel.getTitle() );
              }

              @Override
              public void onError(Throwable e) {

              }

              @Override
              public void onComplete() {

              }
          });
      }

}
