package com.jz.appframe.dagger.module;

import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.data.DataManager;
import com.jz.appframe.presen.LoginPresenter;

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

}
