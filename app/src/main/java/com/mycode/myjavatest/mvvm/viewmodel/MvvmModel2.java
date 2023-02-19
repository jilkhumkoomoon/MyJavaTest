package com.mycode.myjavatest.mvvm.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.mycode.myjavatest.mvvm.base.BaseMvvmModel;

public class MvvmModel2 extends BaseMvvmModel {

    /**
     * 使用ObservableField的方式完成dataBinding 的数据绑定
     * */
    //public ObservableField<String> name2 = new ObservableField<>();

    /**
     * 也同时可以使用LiveData的方式完成dataBinding的数据绑定,但是需要在aseMvvmActivity中添加：
     *
     * */
    public MutableLiveData<String> name2 = new MutableLiveData<>();


    public MvvmModel2(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onResume() {
        //name2.set("MvvmModel2");
        name2.setValue("MvvmModel2");
    }

    public void tvMvvmOnClick(View view) {
        //name2.set("tvMvvmOnClick2");
        name2.setValue("tvMvvmOnClick2");
        getUILiveData().showToast("tvMvvmOnClick2");
    }
}
