package com.mycode.myjavatest.mvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * 这里只是测试部分生命周期接口，如果需要可以继续添加补充
 */

public interface ILifeCircle {
    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onResume();

    void onDestroy();
}
