package com.jz.appframe.data;

import com.jz.appframe.data.local.LoginRequest;
import com.jz.appframe.data.net.Apis;
import com.jz.appframe.data.remote.LoginResponse;

import io.reactivex.Observable;

/**
 * @author jackzhous
 * @package com.jz.appframe.data
 * @filename DataManager
 * date on 2019/2/20 4:42 PM
 * @describe 底层数据控制中心
 * @email jackzhouyu@foxmail.com
 **/
public class DataManager {


    private Apis apis;


    public DataManager() {
        apis = Apis.Factory.createService();
    }


    public Observable<LoginResponse> login(String name, String pass){
        LoginRequest request = new LoginRequest(name, pass);
        return apis.login(request);
    }

}
