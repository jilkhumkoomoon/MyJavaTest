package com.mycode.myjavatest.mvvm.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;

public class BaseMvvmModel extends AndroidViewModel implements LifecycleObserver {

    public MutableLiveData<String> toastLiveData = new MutableLiveData<>();

    private UILiveData mUILiveData;

    public BaseMvvmModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 这里只实现一个  可以继续补充
     * */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }

    public UILiveData getUILiveData() {
        if(mUILiveData == null) {
            mUILiveData = new UILiveData();
        }
        return mUILiveData;
    }

    public class UILiveData{
        public void showToast(String text) {
            toastLiveData.setValue(text);
        }
    }
}
