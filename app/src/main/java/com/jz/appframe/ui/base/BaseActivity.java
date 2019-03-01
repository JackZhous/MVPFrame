package com.jz.appframe.ui.base;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jz.appframe.MyApplication;
import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.dagger.component.DaggerLoginComponent;
import com.jz.appframe.dagger.component.LoginComponent;
import com.jz.appframe.helper.LogHelper;
import com.jz.appframe.helper.ToastHelper;
import com.jz.appframe.presen.base.PView;

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
public abstract class BaseActivity<P extends PView>  extends AppCompatActivity
                                implements CommView,
                                LifecycleOwner{

    private ProgressDialog dialog;

    @Inject
    protected MyApplication application;

    @Inject
    protected P presenter;

    protected abstract int layout();             //Presenter布局文件

    /**
     * 1. 初始化dagger依赖
     * 2. inject此类
     */
    protected abstract void initComponent();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        ButterKnife.bind(this);
        initComponent();

        if(this instanceof LifecycleOwner){
            LogHelper.de_i("recylce ---------");
            this.getLifecycle().addObserver(presenter);
        }
//        getLifecycle().addObserver(presenter);
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
        getLifecycle().removeObserver(presenter);
        presenter = null;
        closeDialog();
    }

    protected MyApplication getMyApp(){
        return (MyApplication)getApplication();
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
    public void gotoActivity(Class object, boolean closed) {
        Intent intent = new Intent(this, object);

        startActivity(intent);

        if(closed){
            finish();
        }
    }

    @Override
    public void closeDialog() {
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

}
