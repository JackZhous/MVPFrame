package com.jz.appframe.dagger.module;

import android.support.v4.app.FragmentActivity;

import com.jz.appframe.mvp.p.LoginBehavior;
import com.jz.appframe.mvp.m.UserModule;
import com.jz.appframe.mvp.m.IUserModule;
import com.jz.appframe.mvp.p.LoginPresenter;
import com.jz.frame.dagger.scope.ActivityScope;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.module
 * @filename LoginModule
 * date on 2019/3/1 11:40 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
public abstract class LoginModule {

    @Binds
    abstract LoginBehavior.LoginAction bindLoginPresenter(LoginPresenter presenter);

    @Binds
    abstract IUserModule bindModule(UserModule module);

    @ActivityScope
    @Provides
    static RxPermissions providePermission(LoginBehavior.LoginView view){
        return new RxPermissions((FragmentActivity) view.getActivity());
    }

}
