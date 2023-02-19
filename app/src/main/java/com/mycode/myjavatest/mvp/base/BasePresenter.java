package com.mycode.myjavatest.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.mycode.myjavatest.mvp.MvpView;

public abstract class BasePresenter<T extends MvpView> extends LifeCirclePresenter<T> {


    public BasePresenter(T iMvpView) {
        super(iMvpView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

}
