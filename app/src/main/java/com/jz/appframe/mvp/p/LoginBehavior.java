package com.jz.appframe.mvp.p;

import com.jz.frame.mvp.p.IPresenter;
import com.jz.frame.mvp.v.IView;

/**
 * @author jackzhous
 * @package com.jz.appframe.behavior
 * @filename LoginBehavior
 * date on 2019/2/20 3:59 PM
 * @describe
 * 登录行为接口
 *  发起行为
 *  响应行为
 * @email jackzhouyu@foxmail.com
 **/
public interface LoginBehavior {

    //动作发起
    interface LoginAction extends IPresenter {

        /**
         * 登录方法
         * @param username 用户名
         * @param passwd 密码
         */
        void login(String username, String passwd);
    }

    //动作响应
    interface LoginView extends IView {
        void loginSuccess(String msg);
    }

}
