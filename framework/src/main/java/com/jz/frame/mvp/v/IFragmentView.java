package com.jz.frame.mvp.v;

import android.app.Activity;

/**
 * @author jackzhous
 * @package com.jz.frame.mvp.v
 * @filename IFragmentView
 * date on 2019/3/8 6:41 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface IFragmentView {

    /**
     * 获取容器id，activity中添加fragment会用到容器id
     * @return
     */
    int getContainerId();
}
