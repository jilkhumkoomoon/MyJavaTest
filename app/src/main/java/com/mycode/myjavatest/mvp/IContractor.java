package com.mycode.myjavatest.mvp;

public interface IContractor {
    interface Iview extends MvpView {
        void setTimer(String timer);
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTimer(String timer) {
        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

}
