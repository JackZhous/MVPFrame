package com.jz.appframe.dagger.component;

import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.dagger.module.LoginModule;
import com.jz.appframe.dagger.scope.ActivityScope;
import com.jz.appframe.ui.LoginActivity;

import dagger.BindsInstance;
import dagger.Component;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.component
 * @filename LoginComponent
 * date on 2019/3/1 11:39 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@ActivityScope
@Component(modules = LoginModule.class, dependencies = ApplicationComponent.class)
public interface LoginComponent {

    void inject(LoginActivity activity);

    /**
     * view方法将UI视图注入到Builder里面去
     * 而LoginModule里面@Binds下的参数LoginPresenter需要这个view
     * Component会自动将而这儿连接在一块
     */
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder view(LoginBehavior.LoginView view);
        Builder appComponent(ApplicationComponent component);
        LoginComponent build();
    }
}
