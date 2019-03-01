package com.jz.appframe;

import android.app.Application;

import com.jz.appframe.dagger.component.ApplicationComponent;
import com.jz.appframe.dagger.component.DaggerApplicationComponent;
import com.jz.appframe.dagger.module.ApplicationModule;
import com.jz.appframe.data.DataManager;
import com.jz.appframe.presen.base.PresenterFactory;

/**
 * @author jackzhous
 * @package com.jz.appframe
 * @filename MyApplication
 * date on 2019/2/21 9:20 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class MyApplication extends Application {

    private PresenterFactory presenterFactory;
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        DataManager manager = new DataManager();
//
//        presenterFactory = new PresenterFactory(manager);

//
//        appComponent = DaggerApplicationComponent.builder()
//                                            .applicationModule(new ApplicationModule(this))
//                                            .build();
        appComponent = DaggerApplicationComponent.builder().application(this).build();
        appComponent.injectApplication(this);
    }


    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

    public PresenterFactory getPresenterFactory() {
        return presenterFactory;
    }
}
