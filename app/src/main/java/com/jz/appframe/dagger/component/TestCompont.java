package com.jz.appframe.dagger.component;


import com.jz.appframe.dagger.module.TestModule;
import com.jz.appframe.mvp.p.TestBehavior;
import com.jz.appframe.ui.fragment.TestFragment;
import com.jz.frame.dagger.component.MyAppComponent;
import com.jz.frame.dagger.scope.FragmentScope;

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
@FragmentScope
@Component(modules = TestModule.class, dependencies = MyAppComponent.class)
public interface TestCompont {

    void inject(TestFragment fragment);


    @Component.Builder
    interface Builder{
        @BindsInstance
        TestCompont.Builder view(TestBehavior.TestView view);         //注入接口
        TestCompont.Builder appComponent(MyAppComponent component);
        TestCompont build();
    }
}
