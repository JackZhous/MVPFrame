package com.jz.appframe.helper;

import com.jz.appframe.data.service.ModuleManager;
import com.jz.appframe.presenter.LoginPresenter;
import com.jz.appframe.presenter.TestPresenter;
import com.jz.frame.help.Args;

/**
 * presenter工厂类，对presenter统一管理
 */
public class FactoryPresenter {

    private static ModuleManager manager;
    private static FactoryPresenter factory;

    public FactoryPresenter() {
    }

    /**
     * 使用前必须调用此方法，初始化service
     * @param service
     */
    public void initFactory(ModuleManager service){
        this.manager = service;
    }


    public static FactoryPresenter getInstance(){
        Args.empty(manager, "service");
        if(factory == null){
            factory = new FactoryPresenter();
        }

        return factory;
    }


    /**
     * 登录页面presenter
     * @return
     */
    public LoginPresenter loginPresenter(){
        return new LoginPresenter(manager);
    }

    public TestPresenter testPresenter(){
        return new TestPresenter(manager);
    }
}
