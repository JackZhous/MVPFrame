package com.jz.appframe.dagger.module;

import com.jz.appframe.mvp.p.LoginBehavior;
import com.jz.appframe.mvp.m.UserModule;
import com.jz.appframe.mvp.m.IUserModule;
import com.jz.appframe.mvp.p.LoginPresenter;

import dagger.Binds;
import dagger.Module;

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
}
