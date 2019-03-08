package com.jz.appframe.dagger.module;

import com.jz.appframe.adapter.TestAdapter;
import com.jz.appframe.mvp.m.ITestModule;
import com.jz.appframe.mvp.m.IUserModule;
import com.jz.appframe.mvp.p.LoginBehavior;
import com.jz.appframe.mvp.p.LoginPresenter;
import com.jz.appframe.mvp.p.TestBehavior;
import com.jz.appframe.mvp.p.TestPresenter;
import com.jz.frame.dagger.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.module
 * @filename TestModule
 * date on 2019/3/8 5:43 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
public abstract class TestModule {

    @Binds
    abstract TestBehavior.TestAction bindLoginPresenter(TestPresenter presenter);


    @Binds
    abstract ITestModule bindModule(com.jz.appframe.mvp.m.TestModule module);

    @FragmentScope
    @Provides
    static TestAdapter providAdapter(TestBehavior.TestView view){
        return new TestAdapter(view.getFragmentContext());
    }
}
