package com.jz.appframe.dagger.module;

import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.behavior.MainBehavior;
import com.jz.appframe.module.MainMoudle;
import com.jz.appframe.module.UserModule;
import com.jz.appframe.presen.IMainModule;
import com.jz.appframe.presen.IUserModule;
import com.jz.appframe.presen.LoginPresenter;
import com.jz.appframe.presen.MainPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.module
 * @filename MainAMoudle
 * date on 2019/3/3 6:58 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
public abstract class MainAMoudle {

    @Binds
    abstract MainBehavior.mainAction bindLoginPresenter(MainPresenter presenter);

    @Binds
    abstract IMainModule bindModule(MainMoudle module);

}
