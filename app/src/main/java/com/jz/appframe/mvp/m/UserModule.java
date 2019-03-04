package com.jz.appframe.mvp.m;

import com.jz.appframe.data.service.UserService;
import com.jz.appframe.data.local.LoginRequest;
import com.jz.appframe.data.bean.User;
import com.jz.appframe.data.remote.LoginResponse;
import com.jz.frame.help.LogHelper;
import com.jz.frame.config.service.IServiceCreator;
import com.jz.frame.dagger.scope.ActivityScope;
import com.jz.frame.mvp.m.BaseModule;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * @author jackzhous
 * @package com.jz.appframe.module
 * @filename UserModule
 * date on 2019/3/3 4:50 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@ActivityScope
public class UserModule  extends BaseModule implements IUserModule {

    @Inject
    public UserModule(IServiceCreator creator) {
        super(creator);
    }

    @Override
    public Observable<User> loginUser(String name, String passwd) {
        LoginRequest request = new LoginRequest(name, passwd, "android");
        return serviceCreator.createService(UserService.class)
                        .login(request)
                        .map(new Function<LoginResponse, User>() {
                            @Override
                            public User apply(LoginResponse loginResponse) throws Exception {
                                LogHelper.de_i(loginResponse);
                                User user = new User(loginResponse.getDetail().getToken(),
                                        loginResponse.getMessage());
                                return user;
                            }
                        });
    }
}
