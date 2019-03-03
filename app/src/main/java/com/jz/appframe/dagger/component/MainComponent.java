package com.jz.appframe.dagger.component;

import com.jz.appframe.MainActivity;
import com.jz.appframe.behavior.MainBehavior;
import com.jz.appframe.dagger.module.MainAMoudle;
import com.jz.appframe.dagger.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.component
 * @filename MainComponent
 * date on 2019/3/3 6:58 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@ActivityScope
@Component(modules = MainAMoudle.class, dependencies = ApplicationComponent.class)
public interface MainComponent {


    void inject(MainActivity activity);

    /**
     * view方法将UI视图注入到Builder里面去
     * 而LoginModule里面@Binds下的参数LoginPresenter需要这个view
     * Component会自动将而这儿连接在一块
     */
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder view(MainBehavior.mainView view);
        Builder appComponent(ApplicationComponent component);
        MainComponent build();
    }

}
