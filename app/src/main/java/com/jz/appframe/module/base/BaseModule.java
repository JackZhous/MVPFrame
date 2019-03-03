package com.jz.appframe.module.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.jz.appframe.data.IServiceCreator;

/**
 * @author jackzhous
 * @package com.jz.appframe.module.base
 * @filename BaseModule
 * date on 2019/3/3 4:56 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class BaseModule implements IModule {


    protected IServiceCreator creator;

    public BaseModule(IServiceCreator creator) {
        this.creator = creator;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void onDestroy(LifecycleOwner owner) {
        creator = null;
        owner.getLifecycle().removeObserver(this);
    }
}
