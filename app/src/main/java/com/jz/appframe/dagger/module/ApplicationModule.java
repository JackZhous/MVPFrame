package com.jz.appframe.dagger.module;

import com.jz.appframe.MyApplication;
import com.jz.appframe.data.DataManager;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author jackzhous
 * @package com.jz.appframe.dagger.module
 * @filename ApplicationModule
 * date on 2019/3/1 11:43 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
public class ApplicationModule {

    protected MyApplication application;


//    public void setApplication(MyApplication application) {
//        this.application = application;
//    }

//    @Provides
//    @Singleton
//    MyApplication provideApplication(){
//        return application;
//    }

    @Provides
    @Singleton
    DataManager provideDataManager(){
        return new DataManager();
    }

}
