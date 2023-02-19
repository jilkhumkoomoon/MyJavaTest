package com.mycode.myjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mycode.myjavatest.mvp.SplashTimerPresenter;
import com.mycode.myjavatest.mvp.ViewInject;
import com.mycode.myjavatest.mvp.base.BaseActivity;

@ViewInject(mainlayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private SplashTimerPresenter timerPresenter = null;
    private TextView mTvTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTvTimer = findViewById(R.id.tv_splash_timer);
        initTimerPresenter();
    }

    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }
    /**
     *
     * */
    @Override
    public void aferBindView() {

    }

    @Override
    public void setTimer(String timer) {
        mTvTimer.setText(timer);
    }
}