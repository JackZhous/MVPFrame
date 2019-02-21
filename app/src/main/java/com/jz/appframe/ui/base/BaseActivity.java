package com.jz.appframe.ui.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jz.appframe.MyApplication;
import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.helper.ToastHelper;
import com.jz.appframe.presen.base.PView;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui.base
 * @filename BaseActivity
 * date on 2019/2/20 4:25 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseActivity<P extends PView>  extends AppCompatActivity implements CommView {

    private ProgressDialog dialog;

    private P presenter;

    protected abstract int layout();             //Presenter布局文件

    protected abstract void onDetach();          //Presenter收尾工作

    protected abstract void onAttach();         //Presenter绑定工作

    protected abstract P provideP();            //创建presenter

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        presenter = provideP();
        onAttach();
    }

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
        onDetach();
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
