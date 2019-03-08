package com.jz.appframe.dagger.component;

import android.app.Activity;

import com.jz.appframe.mvp.p.LoginBehavior;
import com.jz.appframe.dagger.module.LoginModule;
import com.jz.appframe.ui.LoginActivity;
import com.jz.frame.dagger.component.MyAppComponent;
import com.jz.frame.dagger.scope.ActivityScope;

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
@Component(modules = LoginModule.class, dependencies = MyAppComponent.class)
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
        Builder view(LoginBehavior.LoginView view);         //注入接口
        Builder appComponent(MyAppComponent component);
        LoginComponent build();
    }
}
