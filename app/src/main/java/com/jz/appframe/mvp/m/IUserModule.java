package com.jz.appframe.mvp.m;

import com.jz.appframe.data.bean.User;
import com.jz.frame.mvp.m.IModule;

import io.reactivex.Observable;


/**
 * @author jackzhous
 * @package com.jz.appframe.presen
 * @filename IUserModule
 * date on 2019/3/3 5:00 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IUserModule extends IModule {

    Observable<User> loginUser(String name, String passwd);

}
