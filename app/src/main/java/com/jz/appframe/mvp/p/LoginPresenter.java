package com.jz.appframe.mvp.p;

import com.jz.appframe.data.bean.User;
import com.jz.appframe.mvp.m.IUserModule;
import com.jz.frame.dagger.scope.ActivityScope;
import com.jz.frame.mvp.p.BasePresenter;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen
 * @filename LoginPresenter
 * date on 2019/2/20 5:06 PM
 * @describe
 * 负责控制层业务，
 *  吊起Module层接口
 *  响应Module层操作，并将反馈数据传递给adapter或者状态床底到UI
 * @email jackzhouyu@foxmail.com
 **/
@ActivityScope
public class LoginPresenter extends BasePresenter<IUserModule, LoginBehavior.LoginView>
                                                    implements  LoginBehavior.LoginAction{

    @Inject
    public LoginPresenter(IUserModule module, LoginBehavior.LoginView view) {
        super(module, view);
    }


    @Override
    public void login(final String username, String passwd) {
        super.moduleExecute(getModule().loginUser(username, passwd), new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().loginSuccess(user.getMessage());
            }
        });
    }
}
