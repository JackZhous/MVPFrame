package com.jz.appframe.dagger.component;

import android.app.Application;

import com.jz.appframe.MyApplication;
import com.jz.appframe.dagger.module.ApplicationModule;
import com.jz.appframe.data.DataManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.component
 * @filename ApplicationComponent
 * date on 2019/3/1 3:04 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void injectApplication(MyApplication application);

    //向第三Component提供application
    MyApplication getMyApplication();

    DataManager getDataManager();


    /**
     * builder本身就是ApplicationComponent一个内部类，详见其具体生成的类
     * @Component.Builder是自定义这个builder类
     * @BindInstance是给builder里面顶一个属性，并且这个属性是自动provide的，不需要额外在Module里面提供
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);

        ApplicationComponent build();

    }
}
