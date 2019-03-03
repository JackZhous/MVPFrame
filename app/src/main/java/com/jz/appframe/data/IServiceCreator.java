package com.jz.appframe.data;

import android.support.annotation.NonNull;

/**
 * @author jackzhous
 * @package com.jz.appframe.data
 * @filename IServiceCreator
 * date on 2019/3/3 5:08 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IServiceCreator {

    @NonNull
    <T> T createService(Class<T> tClass);

}
