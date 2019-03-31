package com.jz.frame.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jz.frame.R;

/**
 * Created by Android Studio.
 * User: jackzhous
 * Date: 19-3-31
 * Time: 下午6:12
 * 自定义基类DialogFragment 底部动画弹出
 */
public abstract class AbstractBottomDialog  extends DialogFragment {

    //布局视图文件
    protected abstract int layout();

    //点击外部是否消失
    protected abstract boolean clickOutsideDismiss();

    //背景颜色
    protected abstract int background();


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(layout(), null);
        builder.setView(view);
        initView(view);
        return builder.create();
    }

    protected void initView(View view){}

    @Override
    public void onStart() {
        super.onStart();

        getDialog().setCanceledOnTouchOutside(clickOutsideDismiss());
    }


    @Override
    public void onResume() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.windowAnimations = R.anim.anim_enter;
        window.setAttributes(params);
        window.setBackgroundDrawableResource(background());
        super.onResume();
    }
}
