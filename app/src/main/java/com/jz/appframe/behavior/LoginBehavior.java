package com.jz.appframe.behavior;

import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.presen.base.PresenterView;

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
    interface LoginAction extends PresenterView<LoginView> {
        void login(String username, String passwd);
    }

    //动作响应
    interface LoginView extends CommView{
        void loginSuccess(String msg);
    }

}
