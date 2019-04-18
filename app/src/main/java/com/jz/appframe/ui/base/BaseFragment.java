package com.jz.appframe.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jz.appframe.MyApplication;
import com.jz.frame.help.ToastHelper;
import com.jz.frame.mvp.p.IPresenter;
import com.jz.frame.mvp.v.IFragmentView;
import com.jz.frame.mvp.v.IView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui.base
 * @filename BaseVPFragment
 * date on 2019/3/8 5:13 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseFragment<P extends IPresenter> extends Fragment
                                                        implements IView,
                                                                IFragmentView {


    private ProgressDialog dialog;

    @Inject
    protected P presenter;


    protected abstract int provideLayout();

    protected abstract void initDagger();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDagger();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(provideLayout(), container, false);

        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    //初始化组件的，子类自由使用
    protected void initView(View view){

    }


    @Override
    public void showMessage(String msg) {
        ToastHelper.showMsg(msg, getActivity());
    }

    @Override
    public void showMessage(int msg) {
        ToastHelper.showMsg(msg, getActivity());
    }

    private void createDialogAndShow(String content, boolean canDismiss) {
        if (dialog == null) {
            dialog = new ProgressDialog(getActivity());
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
    public void gotoLogin() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        dialog = null;
        presenter = null;
    }

    @Override
    public Activity getFragmentContext() {
        return getActivity();
    }

    protected MyApplication getMyApp(){
        return (MyApplication) getActivity().getApplication();
    }
}
