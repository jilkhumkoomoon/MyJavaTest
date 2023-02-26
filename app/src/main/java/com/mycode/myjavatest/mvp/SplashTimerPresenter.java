package com.mycode.myjavatest.mvp;

import com.mycode.myjavatest.MainActivity;
import com.mycode.myjavatest.mvp.base.BasePresenter;

public class SplashTimerPresenter extends BasePresenter<IContractor.Iview>  implements IContractor.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(IContractor.Iview iMvpView) {
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
    protected IContractor.Iview getEmptyView() {
        return IContractor.emptyView;
    }
}
