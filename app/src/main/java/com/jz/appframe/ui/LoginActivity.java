package com.jz.appframe.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.jz.appframe.R;
import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.ui.base.BaseActivity;

import butterknife.ButterKnife;
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




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        showMessage(getStringValueFromLast("data", "null"));
    }

    @OnClick({R.id.btn_login})
    public void onClick(View view){
        int id = view.getId();

        switch (id){
            case R.id.btn_login:
                getPresenter().login("1212", "password");
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
    protected LoginBehavior.LoginAction provideP() {
        return getMyApp().getPresenterFactory().createLoginPresenter();
    }

    @Override
    protected void onAttach() {
        getPresenter().attach(this);
    }

    @Override
    protected void onDetach() {
        getPresenter().detach();
    }
}
