package com.mycode.myjavatest.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.mycode.myjavatest.mvp.ViewInject;

public abstract class BaseActivity extends LifeCircleActivity {
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if(annotation != null) {
            int mainlayoutId = annotation.mainlayoutId();
            if(mainlayoutId > 0) {
                setContentView(mainlayoutId);
            } else {
                throw new RuntimeException("mainlayoutId < 0");
            }
        } else {
            throw new RuntimeException("annotation =null");
        }
    }

    public abstract void aferBindView();
}
