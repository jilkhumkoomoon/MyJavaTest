package com.moon.module_arouter_java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/trade/detail/activity")
public class TradeDetailActivity extends AppCompatActivity {
    @Autowired
    public String saleId;

    @Autowired
    public String shopId;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ARouter.getInstance().inject(this);
    }
}
