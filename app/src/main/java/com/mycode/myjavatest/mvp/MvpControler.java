package com.mycode.myjavatest.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 静态代理模式,所以同样要实现ILifeCircle 采用中介者设计模式
 * */
public class MvpControler implements ILifeCircle{

    /**
     * set避免重复
     * */
    private Set<ILifeCircle> lifeCircles = new HashSet<>();

    public void savePresenter(ILifeCircle lifeCircle) {
        lifeCircles.add(lifeCircle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> it = lifeCircles.iterator();
        while (it.hasNext()) {
            ILifeCircle presenter = it.next();
            if(intent == null) {
                intent = new Intent();
            }
            if(getArguments == null) {
                getArguments = new Bundle();
            }
            /**
             * 调用管理的present
             * */
            presenter.onCreate(savedInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onResume() {
        Iterator var2 = this.lifeCircles.iterator();
        while (var2.hasNext()) {
            ILifeCircle presenter1 = (ILifeCircle) var2.next();
            presenter1.onResume();
        }
    }

    @Override
    public void onDestroy() {
        Iterator var1 = this.lifeCircles.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.onDestroy();
        }
        this.lifeCircles.clear();
    }
}
