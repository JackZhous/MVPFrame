package com.jz.frame;

import android.app.Application;

import com.jz.frame.config.NetConfig;

/**
 * @author jackzhous
 * @package com.jz.frame
 * @filename MyApp
 * date on 2019/3/4 9:28 AM
 * @describe
 * 此框架必须要使用此Application，如果需求不同，可以直接修改此类
 * @email jackzhouyu@foxmail.com
 **/
public abstract class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

    }


    /**
     * 配置服务器参数,okhttpclient可以自定义，也可以不配置默认
     * @return
     */
    public abstract NetConfig initNetConfig();

}
