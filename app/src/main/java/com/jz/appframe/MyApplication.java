package com.jz.appframe;

import android.app.Application;

import com.jz.appframe.data.service.ApiService;
import com.jz.appframe.data.service.ModuleManager;
import com.jz.appframe.helper.Config;
import com.jz.appframe.helper.FactoryPresenter;
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
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ApiService service = ApiService.Factory.getService(initNetConfig());
        ModuleManager manager = new ModuleManager(service);
        FactoryPresenter factory = FactoryPresenter.getInstance();
        factory.initFactory(manager);

    }


    private NetConfig initNetConfig() {
        return new NetConfig.Builder()
                .setUrl(Config.BASE_URL)
                .setSchmes(Config.SCHMES)
                .setPort(Config.port)
                .setTimeout(10)
                .setUnit(TimeUnit.SECONDS)
                .build();
    }
}
