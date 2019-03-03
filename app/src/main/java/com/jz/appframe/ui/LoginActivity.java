package com.jz.appframe.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.jz.appframe.R;
import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.dagger.component.DaggerLoginComponent;
import com.jz.appframe.dagger.component.LoginComponent;
import com.jz.appframe.helper.LogHelper;
import com.jz.appframe.ui.base.BaseActivity;

import butterknife.OnClick;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui
 * @filename LoginActivity
 * date on 2019/2/20 4:25 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LoginActivity extends BaseActivity<LoginBehavior.LoginAction> implements LoginBehavior.LoginView {


    protected void initComponent(){
        LoginComponent component =  DaggerLoginComponent.builder()
                                    .appComponent(getMyApp().getAppComponent())
                                    .view(this)
                                    .build();
        component.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogHelper.de_i("login application" + application);

    }

    @OnClick({R.id.btn_login})
    public void onClick(View view){
        int id = view.getId();
        if(presenter == null){
            Log.i("j_tag", "null presenter");
            return;
        }else{
            Log.i("j_tag", "not null presenter " + presenter);
        }
        switch (id){
            case R.id.btn_login:
                presenter.login("1212", "password");
        }
    }

    @Override
    public void loginSuccess(String msg) {
        showMessage("login success" + msg);
    }


    @Override
    protected int layout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogHelper.de_i("activity onDestroy");
    }
}
