package com.jz.appframe.presen.base;

import com.jz.appframe.behavior.LoginBehavior;
import com.jz.appframe.data.DataManager;
import com.jz.appframe.helper.Args;
import com.jz.appframe.presen.LoginPresenter;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen.base
 * @filename PresenterFactory
 * date on 2019/2/21 9:18 AM
 * @describe presenter工程类
 * @email jackzhouyu@foxmail.com
 **/
public class PresenterFactory {


    private DataManager dataManager;

    public PresenterFactory(DataManager dataManager) {
        Args.empty(dataManager, "present dataManager");
        this.dataManager = dataManager;
    }

//    public LoginBehavior.LoginAction createLoginPresenter(){
//        return new LoginPresenter(dataManager);
//    }
}
