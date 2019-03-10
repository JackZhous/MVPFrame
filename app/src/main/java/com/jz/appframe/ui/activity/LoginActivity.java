package com.jz.appframe.ui.activity;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui
 * @filename LoginActivity
 * date on 2019/3/8 9:42 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/

import android.util.Log;
import android.view.View;

import com.jz.appframe.R;
import com.jz.appframe.helper.FactoryPresenter;
import com.jz.appframe.presenter.behavior.LoginBehavior;
import com.jz.appframe.ui.base.BaseActivity;
import com.jz.appframe.ui.fragment.TestFragment;
import com.jz.frame.help.Args;
import com.jz.frame.help.LogHelper;


import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginBehavior.LoginAction>
                                        implements LoginBehavior.LoginView {



    @OnClick({R.id.btn_login, R.id.btn_fragment})
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
                break;

            case R.id.btn_fragment:
                Args.replaceFragment(this, TestFragment.newInstance(), R.id.container);
                break;
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

    @Override
    protected LoginBehavior.LoginAction providePresenter() {
        return FactoryPresenter.getInstance().loginPresenter();
    }
}