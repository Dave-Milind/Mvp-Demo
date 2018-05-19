package com.milind.myapp.MainAct;

import com.milind.myapp.BasePresenter;
import com.milind.myapp.BaseView;

import io.reactivex.Observable;

public interface MainContract {

interface View extends BaseView {


       boolean isItAWildCard();
       void getData(String data);


}


interface Presenter extends BasePresenter<View> {


 public void onWildcardClick();
   public void onApiCallClick();

}
}
