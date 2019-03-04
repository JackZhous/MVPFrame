package com.jz.frame.mvp.m;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.jz.frame.config.service.IServiceCreator;

import javax.inject.Inject;

/**
 * @author jackzhous
 * @package com.jz.frame.mvp.m
 * @filename BaseModule
 * date on 2019/3/4 11:00 AM
 * @describe
 * Module层基础类，提供注册服务能力
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseModule implements IModule{


    protected IServiceCreator serviceCreator;

    public BaseModule(IServiceCreator serviceCreator) {
        this.serviceCreator = serviceCreator;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
        serviceCreator = null;
    }
}
