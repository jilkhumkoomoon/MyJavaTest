package com.mycode.myjavatest.mvp.base;

import com.mycode.myjavatest.mvp.ILifeCircle;
import com.mycode.myjavatest.mvp.MvpControler;
import com.mycode.myjavatest.mvp.MvpView;

import java.lang.ref.WeakReference;

public abstract class LifeCirclePresenter<T extends MvpView> implements ILifeCircle {

    /**
     * 对View层的引用采用弱引用的方式
     * */
    protected WeakReference<T> weakReference = null;

    private void attachView(T view) {
        if(weakReference == null) {
            weakReference = new WeakReference<>(view);
        } else {
            T v = weakReference.get();
            if(v != view) {
                weakReference = new WeakReference<>(view);
            }
        }
    }

    public LifeCirclePresenter(T iMvpView) {
        super();

        /**
         * p绑定view
         * */
        attachView(iMvpView);

        /**
         * 这里创建静态代理对象，创建的过程中
         * */
        MvpControler controler = iMvpView.getMvpControler();
        controler.savePresenter(this);
    }

    protected T getView() {
        T view = weakReference != null? (T)weakReference.get():null;
        if(view == null) {
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();

}
