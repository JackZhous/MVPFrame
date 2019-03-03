package com.jz.appframe.presen.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.helper.LogHelper;
import com.jz.appframe.module.base.IModule;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen.base
 * @filename BasePresenter
 * date on 2019/2/20 5:07 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class BasePresenter<M extends IModule, T extends CommView> implements PresenterView, LifecycleObserver{
    private T view;
    private M module;

    //缓存响应者的引用
    protected CompositeDisposable disposableRaiser;

    public BasePresenter(M module, T view) {
        this.module = module;
        this.view = view;
        disposableRaiser = new CompositeDisposable();

        bindLifcycle();
    }

    public T getView() {
        return view;
    }

    public M getModule() {
        return module;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void onCreate() {
        LogHelper.de_i("BasePresenter onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
        view = null;
        module = null;
        if (disposableRaiser != null && !disposableRaiser.isDisposed()){
            disposableRaiser.clear();
        }
        LogHelper.de_i("BasePresenter onDestroy");
    }

    /**
     * presenter绑定视图生命周期
     */
    private void bindLifcycle(){
        if(view instanceof LifecycleOwner){
            ((LifecycleOwner) view).getLifecycle().addObserver(this);
            ((LifecycleOwner) view).getLifecycle().addObserver(module);
        }
    }
}
