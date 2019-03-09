package com.jz.appframe.mvp.m;

import com.jz.appframe.data.bean.Data;
import com.jz.frame.mvp.m.IModule;

import io.reactivex.Observable;


/**
 * @author jackzhous
 * @package com.jz.appframe.mvp.m
 * @filename ITestModule
 * date on 2019/3/8 6:19 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface ITestModule extends IModule {

    Observable<Data> loadList(int limit, int page);

}
