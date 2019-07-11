package com.jz.frame.mvp.p;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

import com.jz.frame.mvp.v.IView;

/**
 * @author jackzhous
 * @package com.jz.frame.mvp.p
 * @filename IPresenter
 * date on 2019/3/4 10:47 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IPresenter<V extends IView> extends LifecycleObserver {

    //view层onCreate时调用，处理Presenter的一些初始化工作
    void attach(V view);

    //view销毁destroy时调用，处理一些收尾工作
    void onDestroy(LifecycleOwner owner);
}
