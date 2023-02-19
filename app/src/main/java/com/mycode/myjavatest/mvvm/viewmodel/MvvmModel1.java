package com.mycode.myjavatest.mvvm.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.mycode.myjavatest.mvvm.base.BaseMvvmModel;

public class MvvmModel1 extends BaseMvvmModel {

    public ObservableField<String> name1 = new ObservableField<>();

    public MvvmModel1(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onResume() {
        name1.set("MvvmModel1");
    }

    public void tvMvvmOnClick(View view) {
        name1.set("tvMvvmOnClick1");
        getUILiveData().showToast("tvMvvmOnClick1");
    }
}
