package com.jz.frame.mvp.v;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

/**
 * @author jackzhous
 * @package com.jz.frame.mvp.v
 * @filename IView
 * date on 2019/3/4 10:47 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IView extends LifecycleOwner {
    void showMessage(String msg);

    void showMessage(int msg);

    void showDialog(String msg, boolean canDismiss);

    void showDialog(int strId, boolean canDismiss);

    void closeDialog();

    void gotoLogin();

    void gotoActivity(Class myclass);
}
