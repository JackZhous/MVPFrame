package com.jz.appframe.mvp.m;

import com.jz.frame.config.service.IServiceCreator;
import com.jz.frame.dagger.scope.FragmentScope;
import com.jz.frame.mvp.m.BaseModule;

import javax.inject.Inject;

/**
 * @author jackzhous
 * @package com.jz.appframe.mvp.m
 * @filename TestModule
 * date on 2019/3/8 6:18 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@FragmentScope
public class TestModule extends BaseModule implements ITestModule{

    @Inject
    public TestModule(IServiceCreator serviceCreator) {
        super(serviceCreator);
    }

    @Override
    protected void onModuleDestroy() {

    }
}
