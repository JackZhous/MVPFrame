package com.jz.appframe.presen.base;

import android.arch.lifecycle.LifecycleOwner;

import com.jz.appframe.behavior.base.CommView;

/**
 * @author jackzhous
 * @package com.jz.appframe.behavior
 * @filename PresenterView
 * date on 2019/2/20 4:17 PM
 * @describe
 * presenter基础行为
 * @email jackzhouyu@foxmail.com
 **/
public interface PresenterView extends PView{

    void onCreate();            //绑定行为

    void onDestroy(LifecycleOwner owner);                 //解绑
}
