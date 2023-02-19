package com.mycode.myjavatest.mvp;

import com.mycode.myjavatest.MainActivity;
import com.mycode.myjavatest.mvp.base.BasePresenter;

public class SplashTimerPresenter extends BasePresenter<MvpView>  {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(MvpView iMvpView) {
        super(iMvpView);
    }

    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTimer(time + "秒");

            }

            @Override
            public void onFinish() {
                getView().setTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }
    @Override
    protected MvpView getEmptyView() {
        return IContractor.emptyView;
    }
}
