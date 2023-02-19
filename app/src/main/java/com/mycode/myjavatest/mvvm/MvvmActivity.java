package com.mycode.myjavatest.mvvm;

import com.mycode.myjavatest.BR;
import com.mycode.myjavatest.R;
import com.mycode.myjavatest.databinding.ActivityMvvmBinding;
import com.mycode.myjavatest.mvvm.base.BaseMvvmActivity;
import com.mycode.myjavatest.mvvm.viewmodel.MvvmModel1;
import com.mycode.myjavatest.mvvm.viewmodel.MvvmModel2;


@MvvmViewInject(mainlayoutId = R.layout.activity_mvvm
        ,viewModelId = {BR.mvvm1,BR.mvvm2}
        ,viewModelClass = {MvvmModel1.class, MvvmModel2.class})
public class MvvmActivity extends BaseMvvmActivity<ActivityMvvmBinding> {
    @Override
    protected void afterBindView() {
    }
}
