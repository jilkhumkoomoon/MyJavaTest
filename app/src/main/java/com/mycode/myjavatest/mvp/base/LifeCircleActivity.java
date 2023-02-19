package com.mycode.myjavatest.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mycode.myjavatest.mvp.MvpControler;
import com.mycode.myjavatest.mvp.MvpView;

public class LifeCircleActivity extends AppCompatActivity implements MvpView {

    private MvpControler mvpControler = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if(intent == null) {
            intent = new Intent();
        }
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null) {
            mvpControler.onCreate(savedInstanceState,intent,null);
        }

    }


    @Override
    public MvpControler getMvpControler() {
        return null;
    }

    @Override
    public void setTimer(String timer) {

    }
}
