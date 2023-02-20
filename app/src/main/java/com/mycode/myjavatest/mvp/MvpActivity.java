package com.mycode.myjavatest.mvp;

import android.os.Bundle;
import android.widget.TextView;

import com.mycode.myjavatest.R;
import com.mycode.myjavatest.mvp.base.BaseActivity;

@ViewInject(mainlayoutId = R.layout.activity_main)
public class MvpActivity extends BaseActivity implements IContractor.Iview{
    private IContractor.IPresenter timerPresenter;
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
