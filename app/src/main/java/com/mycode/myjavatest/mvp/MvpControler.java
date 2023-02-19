package com.mycode.myjavatest.mvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * 静态代理模式
 * */
public class MvpControler implements ILifeCircle{

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void savePresenter(ILifeCircle p) {

    }
}
