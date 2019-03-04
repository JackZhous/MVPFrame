package com.jz.frame.mvp.p;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

/**
 * @author jackzhous
 * @package com.jz.frame.mvp.p
 * @filename IPresenter
 * date on 2019/3/4 10:47 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IPresenter extends LifecycleObserver {

    //view层onCreate时调用，处理Presenter的一些初始化工作
    void onCreate();

    //view销毁destroy时调用，处理一些收尾工作
    void onDestroy(LifecycleOwner owner);
}
