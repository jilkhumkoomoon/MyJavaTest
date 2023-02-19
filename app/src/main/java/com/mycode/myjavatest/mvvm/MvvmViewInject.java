package com.mycode.myjavatest.mvvm;

import androidx.lifecycle.ViewModel;

import com.mycode.myjavatest.mvvm.base.BaseMvvmModel;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface MvvmViewInject {
    int mainlayoutId() default -1;
    int [] viewModelId() default 0;
    Class<? extends BaseMvvmModel>[] viewModelClass();
    //Class [] viewModelClass();
}
