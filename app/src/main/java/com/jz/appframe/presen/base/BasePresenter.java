package com.jz.appframe.presen.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.data.DataManager;
import com.jz.appframe.helper.LogHelper;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen.base
 * @filename BasePresenter
 * date on 2019/2/20 5:07 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class BasePresenter<T extends CommView> implements PresenterView<T>{
    private T view;

    //缓存响应者的引用
    protected CompositeDisposable disposableRaiser;

    //网络库API
    protected DataManager dataManager;

    public BasePresenter(DataManager dataManager, T view) {
        this.dataManager = dataManager;
        this.view = view;
        disposableRaiser = new CompositeDisposable();

//        bindLifcycle();
    }

    public T getView() {
        return view;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void attach(T view) {
//        this.view = view;
        LogHelper.de_i("BasePresenter attach");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void detach() {
//        unBindLifecycle();
        view = null;
        if (disposableRaiser != null && !disposableRaiser.isDisposed()){
            disposableRaiser.clear();
        }
        LogHelper.de_i("BasePresenter onDestroy");
    }


//    /**
//     * presenter绑定视图生命周期
//     */
//    private void bindLifcycle(){
//        if(view instanceof LifecycleOwner){
//            ((LifecycleOwner) view).getLifecycle().addObserver(this);
//        }
//    }
//
//    /**
//     * 解绑生命周期
//     */
//    private void unBindLifecycle(){
//        if(view instanceof LifecycleOwner){
//            ((LifecycleOwner) view).getLifecycle().removeObserver(this);
//        }
//    }


}
