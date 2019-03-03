package com.jz.appframe.presen;

import com.jz.appframe.data.bean.User;
import com.jz.appframe.module.base.IModule;

import io.reactivex.Observable;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen
 * @filename IMainModule
 * date on 2019/3/3 6:52 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IMainModule extends IModule {

    Observable<User> loginUser(String name, String passwd);
}
