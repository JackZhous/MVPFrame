package com.jz.appframe.ui.base;

import com.jz.appframe.ui.LoginActivity;

/**
 * @author jackzhous
 * @package com.jack.ui.base
 * @filename ActFactory
 * date on 2019/2/20 11:08 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class ActFactory {


    public static final ActFactory INSTANCE = new ActFactory();

    public static final int LOGIN = 1;

    public ActFactory() {
    }

    public Class newActClass(int action){
        switch (action){
            case LOGIN:
                return LoginActivity.class;
        }
        return null;
    }

}
