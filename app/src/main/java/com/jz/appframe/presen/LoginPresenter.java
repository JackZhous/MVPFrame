package com.jz.appframe.presen;

import android.util.Log;

import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.data.DataManager;
import com.jz.appframe.data.remote.LoginResponse;
import com.jz.appframe.helper.RxTransformHelper;
import com.jz.appframe.presen.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen
 * @filename LoginPresenter
 * date on 2019/2/20 5:06 PM
 * @describe
 * 登录的Presenter
 * @email jackzhouyu@foxmail.com
 **/
public class LoginPresenter extends BasePresenter<LoginBehavior.LoginView>
                                                    implements  LoginBehavior.LoginAction{

    @Inject
    public LoginPresenter(DataManager dataManager, LoginBehavior.LoginView view) {
        super(dataManager, view);
        Log.i("j_tag", "view presenter " + view);
    }


    @Override
    public void login(String username, String passwd) {
        Disposable disposable = dataManager.login(username, passwd)
                .subscribeOn(Schedulers.io())
                .compose(RxTransformHelper.<LoginResponse>ioMainProgress(getView(), "加载中", false))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxTransformHelper.<LoginResponse>ioMainException(getView()))
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        getView().loginSuccess(loginResponse.getMessage());
                    }
                });

        disposableRaiser.add(disposable);
    }
}
