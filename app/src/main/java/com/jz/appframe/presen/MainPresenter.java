package com.jz.appframe.presen;

import com.jz.appframe.behavior.MainBehavior;
import com.jz.appframe.helper.LogHelper;
import com.jz.appframe.presen.base.BasePresenter;

import javax.inject.Inject;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen
 * @filename MainPresenter
 * date on 2019/3/3 6:51 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class MainPresenter extends BasePresenter<IMainModule, MainBehavior.mainView> implements MainBehavior.mainAction {

    @Inject
    public MainPresenter(IMainModule module, MainBehavior.mainView view) {
        super(module, view);
    }

    @Override
    public void login(String username, String passwd) {
        LogHelper.de_i("main module " + getModule());
    }
}
