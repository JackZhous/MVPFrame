package com.jz.frame.config.service;

import android.support.annotation.NonNull;

/**
 * @author jackzhous
 * @package com.jz.frame.config
 * @filename IServiceCreator
 * date on 2019/3/4 9:58 AM
 * @describe 底层网络服务创建类
 * @email jackzhouyu@foxmail.com
 **/
public interface IServiceCreator {

    /**
     * 创建服务方法
     * @param tClass 服务class
     * @param <T>  服务实例
     * @return
     */
    @NonNull
    <T> T createService(Class<T> tClass);
}
