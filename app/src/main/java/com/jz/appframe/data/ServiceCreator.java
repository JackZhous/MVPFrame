package com.jz.appframe.data;

import android.media.JetPlayer;
import android.support.annotation.NonNull;

import com.jz.appframe.helper.LogHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import retrofit2.Retrofit;

/**
 * @author jackzhous
 * @package com.jz.appframe.data
 * @filename ServiceCreator
 * date on 2019/3/3 5:03 PM
 * @describe
 * service 创建器
 * @email jackzhouyu@foxmail.com
 **/
@Singleton
public class ServiceCreator implements IServiceCreator{

    /**
     * 懒加载模式，相当于一个池子，每次都会从池子中取出一个retrofit，但是retrofit是同一个;
     * 只有第一次取的时候才会初始化
     */
    @Inject
    Lazy<Retrofit> retrofit;

    @Inject
    public ServiceCreator() {
    }

    @NonNull
    @Override
    public <T> T createService(Class<T> tClass) {
        LogHelper.de_i("retrofit " + retrofit.get());
        return retrofit.get().create(tClass);
    }
}
