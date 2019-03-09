package com.jz.appframe.mvp.m;

import com.jz.appframe.data.bean.Data;
import com.jz.appframe.data.bean.TestBean;
import com.jz.appframe.data.service.TestService;
import com.jz.frame.config.service.IServiceCreator;
import com.jz.frame.dagger.scope.FragmentScope;
import com.jz.frame.help.LogHelper;
import com.jz.frame.mvp.m.BaseModule;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

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

    private TestService service;


    @Inject
    public TestModule(IServiceCreator serviceCreator) {
        super(serviceCreator);
        service = serviceCreator.createService(TestService.class);
    }

    @Override
    public Observable<Data> loadList(int limit, int page) {

        return service.loadImg(limit, page)
                            .flatMap(new Function<TestBean, ObservableSource<Data>>() {
                                @Override
                                public ObservableSource<Data> apply(TestBean testBean) throws Exception {
                                    return Observable.fromIterable(testBean.getData());
                                }
                            });
    }

    @Override
    protected void onModuleDestroy() {

    }
}
