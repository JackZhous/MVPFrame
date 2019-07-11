package com.jz.appframe.data.service;

import com.jz.appframe.data.bean.Data;
import com.jz.appframe.data.bean.TestBean;
import com.jz.appframe.data.bean.User;
import com.jz.appframe.data.local.LoginRequest;
import com.jz.appframe.data.remote.LoginResponse;
import com.jz.frame.mvp.m.IModule;

import io.reactivex.Observable;

/**
 * Module层网络管理
 */
public class ModuleManager implements IModule {

    private ApiService service;

    public ModuleManager(ApiService service) {
        this.service = service;
    }


    /**
     * login登录
     * @param name
     * @param pass
     * @return
     */
    public Observable<LoginResponse> login(String name, String pass){
        LoginRequest request = new LoginRequest(name, pass, "android");
        return service.login(request);
    }

    public Observable<TestBean> freshList(int limit, int page){
        return service.freshList(limit, page);
    }


}
