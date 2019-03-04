package com.jz.frame.config.service;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import dagger.Lazy;
import retrofit2.Retrofit;

/**
 * @author jackzhous
 * @package com.jz.frame.config.base
 * @filename ServiceCreator
 * date on 2019/3/4 9:59 AM
 * @describe 网络服务创建类
 * @email jackzhouyu@foxmail.com
 **/
public class ServiceCreator implements IServiceCreator {

    /**
     * lazy懒加载模式，每次get其实是一个对象，只有第一次的时候才会初始化
     */
    @Inject
    Lazy<Retrofit> retrofit;

    @Inject
    public ServiceCreator() {
    }

    @NonNull
    @Override
    public <T> T createService(Class<T> tClass) {

        return retrofit.get().create(tClass);
    }
}
