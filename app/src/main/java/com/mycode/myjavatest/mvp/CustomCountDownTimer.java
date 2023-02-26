package com.mycode.myjavatest.mvp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class CustomCountDownTimer implements Runnable{

    private int countDownTime;
    private final Handler handler;
    private final ICountDownHandler countDownHandler;
    private boolean isRun;
    private HandlerThread mMediaHandlerThread ;

    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler){
//        mMediaHandlerThread = new HandlerThread();
//        mMediaHandlerThread.start();
        this.handler = new Handler(Looper.getMainLooper()) ;
        this.countDownTime = time;
        this.countDownHandler = countDownHandler;
    }


    @Override
    public void run() {
        if(isRun){
            if(countDownHandler != null){
                countDownHandler.onTicker(countDownTime);
            }
            if(countDownTime == 0){
                cancel();
                if(countDownHandler != null){
                    countDownHandler.onFinish();
                }
            } else {
                countDownTime  = --countDownTime;
                handler.postDelayed(this,1000);
            }
        }
    }


    public void start(){
        isRun = true;
        handler.post(this);
    }
    //跳出循环 终止
    public void cancel(){
        isRun=false;
        handler.removeCallbacks(this);
    }

    public void setCountDownTime(int time) {
        this.countDownTime = time;
    }

    public interface ICountDownHandler{
        void onTicker(int time);

        void onFinish();
    }
}
