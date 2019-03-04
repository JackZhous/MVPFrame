package com.jz.frame.help;

import android.util.Log;

import com.google.gson.Gson;

/**
 * @author jackzhous
 * @package com.jz.appframe.helper
 * @filename LogHelper
 * date on 2019/3/1 5:11 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LogHelper {

    private static final String TAG = "j_tag";

    public static final void de_i(String msg){
        Log.i(TAG, msg);
    }

    public static final void de_i(Object msg){
        String objMsg = new Gson().toJson(msg);
        Log.i(TAG, objMsg);
    }

}
