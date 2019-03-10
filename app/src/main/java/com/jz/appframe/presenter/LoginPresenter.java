package com.jz.appframe.presenter;

import android.Manifest;
import android.support.v4.app.FragmentActivity;

import com.jz.appframe.data.remote.LoginResponse;
import com.jz.appframe.data.service.ModuleManager;
import com.jz.appframe.presenter.behavior.LoginBehavior;
import com.jz.frame.help.LogHelper;
import com.jz.frame.mvp.p.BasePresenter;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;


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
public class LoginPresenter extends BasePresenter<ModuleManager, LoginBehavior.LoginView>
                                                    implements  LoginBehavior.LoginAction{



    public LoginPresenter(ModuleManager module) {
        super(module);
    }


    @Override
    public void login(final String username, String passwd) {
        super.moduleExecute(getModule().login(username, passwd), new Consumer<LoginResponse>() {
            @Override
            public void accept(LoginResponse user) throws Exception {
                getView().loginSuccess(user.getMessage());
            }
        });
    }

    @Override
    public void initPermission(FragmentActivity activity) {
        RxPermissions permissions = new RxPermissions(activity);

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
