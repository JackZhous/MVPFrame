package com.jz.frame.help;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @author jackzhous
 * @package com.jack.util
 * @filename Args
 * date on 2019/2/20 9:53 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class Args {

    public static void empty(Object obj, String msg){
        if(obj == null){
            throw new IllegalArgumentException(msg + "may not null");
        }
    }

    public static void positive(int number, String msg){
        if(number <= 0){
            throw new IllegalStateException(msg + "may not positive");
        }
    }

    /**
     * replace方式打开一个fragment
     */
    public static void replaceFragment(FragmentActivity context, Fragment fragment, int resId){
        empty(context, "replace fragment");
        empty(fragment, "replace fragment");

        FragmentManager manager = context.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(resId, fragment);
        transaction.commit();
    }


}
