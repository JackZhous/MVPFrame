package com.jz.appframe.module;

import com.jz.appframe.dagger.scope.ActivityScope;
import com.jz.appframe.data.IServiceCreator;
import com.jz.appframe.data.MainService;
import com.jz.appframe.data.bean.User;
import com.jz.appframe.helper.LogHelper;
import com.jz.appframe.module.base.BaseModule;
import com.jz.appframe.presen.IMainModule;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author jackzhous
 * @package com.jz.appframe.module
 * @filename MainMoudle
 * date on 2019/3/3 6:55 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@ActivityScope
public class MainMoudle extends BaseModule implements IMainModule {

    @Inject
    public MainMoudle(IServiceCreator creator) {
        super(creator);

        MainService  service = creator.createService(MainService.class);
        LogHelper.de_i("main mainService " + service + " IServiceCreator " + creator);

    }

    @Override
    public Observable<User> loginUser(String name, String passwd) {
        return null;
    }
}
