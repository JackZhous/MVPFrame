package com.jz.appframe.module.base;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

/**
 * @author jackzhous
 * @package com.jz.appframe.module
 * @filename IModule
 * date on 2019/3/3 4:55 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IModule extends LifecycleObserver {


    void onDestroy(LifecycleOwner owner);


}
