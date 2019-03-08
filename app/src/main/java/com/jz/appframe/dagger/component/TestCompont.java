package com.jz.appframe.dagger.component;

import android.app.Activity;

import com.jz.appframe.dagger.module.TestModule;
import com.jz.appframe.mvp.p.TestBehavior;
import com.jz.appframe.ui.fragment.TestFragment;
import com.jz.frame.dagger.component.MyAppComponent;

import dagger.BindsInstance;
import dagger.Component;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.component
 * @filename TestCompont
 * date on 2019/3/8 5:42 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Component(modules = TestModule.class, dependencies = MyAppComponent.class)
public interface TestCompont {

    void inject(TestFragment fragment);


    @Component.Builder
    interface Builder{
        @BindsInstance
        LoginComponent.Builder view(TestBehavior.TestView view);         //注入接口
        LoginComponent.Builder appComponent(MyAppComponent component);
        LoginComponent build();
    }
}
