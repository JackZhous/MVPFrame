package com.jz.appframe.behavior;

import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.presen.base.PresenterView;

/**
 * @author jackzhous
 * @package com.jz.appframe.behavior
 * @filename MainBehavior
 * date on 2019/3/3 6:49 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface MainBehavior {
    //动作发起
    interface mainAction extends PresenterView {

        /**
         * 登录方法
         * @param username 用户名
         * @param passwd 密码
         */
        void login(String username, String passwd);
    }

    //动作响应
    interface mainView extends CommView {
        void loginSuccess(String msg);
    }
}
