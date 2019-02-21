package com.jz.appframe.behavior.base;

/**
 * @author jackzhous
 * @package com.jz.appframe.behavior.base
 * @filename CommView
 * date on 2019/2/20 4:02 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface CommView {
    void showMessage(String msg);

    void showMessage(int msg);

    void showDialog(String msg, boolean canDismiss);

    void showDialog(int strId, boolean canDismiss);

    void closeDialog();

    void gotoActivity(Class object, boolean closed);
}
