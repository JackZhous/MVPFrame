package com.jz.frame.dagger.component;

import com.jz.frame.MyApp;
import com.jz.frame.config.service.IServiceCreator;
import com.jz.frame.config.NetConfig;
import com.jz.frame.dagger.module.MyAppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * @author jackzhous
 * @package com.jz.frame.dagger.component
 * @filename MyAppComponent
 * date on 2019/3/4 9:32 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Singleton
@Component(modules = MyAppModule.class)
public interface MyAppComponent {

    void inject(MyApp app);

    //以下是整个app提供的单利实例
    MyApp application();
    IServiceCreator serviceCreator();


    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(MyApp app);
        @BindsInstance
        Builder netConfig(NetConfig config);

        MyAppComponent build();
    }

}
