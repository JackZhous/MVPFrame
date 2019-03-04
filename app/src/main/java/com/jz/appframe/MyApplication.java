package com.jz.appframe;

import com.jz.frame.MyApp;
import com.jz.frame.config.NetConfig;

import java.util.concurrent.TimeUnit;


/**
 * @author jackzhous
 * @package com.jz.appframe
 * @filename MyApplication
 * date on 2019/2/21 9:20 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class MyApplication extends MyApp {


    @Override
    public void onCreate() {
        super.onCreate();

    }



    @Override
    public NetConfig initNetConfig() {
        return new NetConfig.Builder()
                .setUrl("www.baidu.com")
                .setSchmes("https://")
                .setPort(443)
                .setTimeout(10)
                .setUnit(TimeUnit.SECONDS)
                .build();
    }
}
