package com.jz.appframe;

import android.app.Application;

import com.jz.appframe.data.DataManager;
import com.jz.appframe.presen.base.PresenterFactory;

/**
 * @author jackzhous
 * @package com.jz.appframe
 * @filename MyApplication
 * date on 2019/2/21 9:20 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class MyApplication extends Application {

    private PresenterFactory presenterFactory;


    @Override
    public void onCreate() {
        super.onCreate();

        DataManager manager = new DataManager();

        presenterFactory = new PresenterFactory(manager);
    }


    public PresenterFactory getPresenterFactory() {
        return presenterFactory;
    }
}
