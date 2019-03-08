package com.jz.appframe.mvp.p;

import android.Manifest;
import android.util.Log;

import com.jz.appframe.data.bean.User;
import com.jz.appframe.mvp.m.IUserModule;
import com.jz.frame.dagger.scope.ActivityScope;
import com.jz.frame.help.LogHelper;
import com.jz.frame.mvp.p.BasePresenter;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;



import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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
    RxPermissions permissions;

    @Inject
    public LoginPresenter(IUserModule module, LoginBehavior.LoginView view) {
        super(module, view);
    }


    @Override
    public void login(final String username, String passwd) {
        super.moduleExecute(getModule().loginUser(username, passwd), new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().loginSuccess(user.getMessage());
            }
        });
    }

    @Override
    public void onCreate() {

        Disposable disposable =  permissions.requestEach(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if(permission.granted){
                            LogHelper.de_i("granted");
                        }else if(permission.shouldShowRequestPermissionRationale){
                            LogHelper.de_i("shouldShowRequestPermissionRationale");
                        }else {
                            LogHelper.de_i("deny");
                        }
                    }
                });

        addDisposable(disposable);

    }

    @Override
    protected void onPresenterDestroy() {

    }
}
