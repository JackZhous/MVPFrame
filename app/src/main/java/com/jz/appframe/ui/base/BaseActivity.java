package com.jz.appframe.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jz.appframe.MyApplication;
import com.jz.frame.MyApp;
import com.jz.frame.help.ToastHelper;
import com.jz.frame.mvp.p.IPresenter;
import com.jz.frame.mvp.v.IActivityView;
import com.jz.frame.mvp.v.IView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui.base
 * @filename BaseActivity
 * date on 2019/2/20 4:25 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseActivity<P extends IPresenter>  extends AppCompatActivity
                                                    implements IView, IActivityView {

    private ProgressDialog dialog;

    @Inject
    protected P presenter;

    //自定义application时可以用这个实例强转
    @Inject
    MyApp myApp;

    protected abstract int layout();             //布局文件

    /**
     * 1. 初始化dagger依赖
     * 2. inject此类
     */
    protected abstract void initDagger();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        ButterKnife.bind(this);
        initDagger();

    }

    /**
     * 自动显示消息内容
     * @param msg 消息
     */
    @Override
    public void showMessage(String msg) {
        ToastHelper.showMsg(msg, this);
    }

    @Override
    public void showMessage(int msg) {
        ToastHelper.showMsg(msg, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
        closeDialog();
    }

    protected MyApplication getMyApp(){
        return (MyApplication) getApplication();
    }



    protected String getStringValueFromLast(String key, String defaultValue){
        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return defaultValue;
        }
        return bundle.getString(key, defaultValue);
    }


    private void createDialogAndShow(String content, boolean canDismiss) {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }

        dialog.setCanceledOnTouchOutside(canDismiss);
        dialog.setMessage(content);
        dialog.show();
    }


    @Override
    public void showDialog(int strId, boolean canDismiss) {
        String msg = getString(strId);
        createDialogAndShow(msg, canDismiss);
    }

    @Override
    public void showDialog(String msg, boolean canDismiss) {
        createDialogAndShow(msg, canDismiss);
    }


    @Override
    public void closeDialog() {
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void gotoLogin() {

    }
}
