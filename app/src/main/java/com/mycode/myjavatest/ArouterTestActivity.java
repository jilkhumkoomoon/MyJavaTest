package com.mycode.myjavatest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

public class ArouterTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().build("/trade/detail/activity")
                .withString("shopId", "1001")
                .withString("saleId", "1002")
                .navigation();
    }
}
