package com.jz.appframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jz.appframe.behavior.MainBehavior;
import com.jz.appframe.dagger.component.DaggerMainComponent;
import com.jz.appframe.dagger.component.MainComponent;
import com.jz.appframe.dagger.module.MainAMoudle;
import com.jz.appframe.helper.ActBuilder;
import com.jz.appframe.helper.Config;
import com.jz.appframe.helper.LogHelper;
import com.jz.appframe.module.MainMoudle;
import com.jz.appframe.ui.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainBehavior.mainAction> implements MainBehavior.mainView {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogHelper.de_i("main application" + application);

    }


    @OnClick({R.id.btn_click})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_click:
                gotoLogin();
                break;
        }
    }


    private void gotoLogin(){
        new ActBuilder().setSrc(this)
                        .setStringValue("data", "jump to login page")
                        .setTarget(Config.ACT_LOGIN)
                        .toAct(true);
    }

    @Override
    public void loginSuccess(String msg) {

    }

    @Override
    protected int layout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent() {
        MainComponent mainMoudle = DaggerMainComponent.builder()
                                .appComponent(getMyApp().getAppComponent())
                                .view(this)
                                .build();
        mainMoudle.inject(this);
    }
}
