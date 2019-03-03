package com.jz.appframe.presen;

import android.util.Log;

import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.dagger.scope.ActivityScope;
import com.jz.appframe.data.bean.User;
import com.jz.appframe.helper.LogHelper;
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
 * 负责控制层业务，
 *  吊起Module层接口
 *  响应Module层操作，并将反馈数据传递给adapter或者状态床底到UI
 * @email jackzhouyu@foxmail.com
 **/
@ActivityScope
public class LoginPresenter extends BasePresenter<IUserModule, LoginBehavior.LoginView>
                                                    implements  LoginBehavior.LoginAction{

    @Inject
    public LoginPresenter(IUserModule module, LoginBehavior.LoginView view) {
        super(module, view);
        LogHelper.de_i("login module " + getModule());
    }


    @Override
    public void login(String username, String passwd) {
        Disposable disposable = getModule().loginUser(username, passwd)
                .subscribeOn(Schedulers.io())
                .compose(RxTransformHelper.<User>ioMainProgress(getView(), "加载中", false))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxTransformHelper.<User>ioMainException(getView()))
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User loginResponse) throws Exception {
                        getView().loginSuccess(loginResponse.getMessage());
                    }
                });

        disposableRaiser.add(disposable);
    }
}
