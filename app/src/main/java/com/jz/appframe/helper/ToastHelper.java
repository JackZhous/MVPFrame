package com.jz.appframe.helper;

import android.content.Context;
import android.widget.Toast;

public class ToastHelper {

    public static void showMsg(String msg, Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


    public static void showMsg(int strId, Context context){
        String msg = context.getString(strId);
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
