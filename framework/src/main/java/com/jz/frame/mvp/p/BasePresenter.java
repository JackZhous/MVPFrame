package com.jz.frame.mvp.p;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;

import com.jz.frame.help.RxTransformHelper;
import com.jz.frame.mvp.m.IModule;
import com.jz.frame.mvp.v.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author jackzhous
 * @package com.jz.frame.mvp.p
 * @filename BasePresenter
 * date on 2019/3/4 10:50 AM
 * @describe 基础类presenter,完成声明周期的绑定以及初始化工作
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BasePresenter<M extends IModule, V extends IView> implements IPresenter<V> {

    private V view;
    private M module;
    //缓存响应者的引用
    private CompositeDisposable disposableRaiser;


    public BasePresenter(M module) {
        this.module = module;
        disposableRaiser = new CompositeDisposable();

        bindLifcycle();
    }

    public V getView() {
        return view;
    }

    public M getModule() {
        return module;
    }

    protected <T> void moduleExecute(@NonNull final Observable<T> observable, final Consumer<T> onNext){
        Disposable disposable = observable.subscribeOn(Schedulers.io())
                .compose(RxTransformHelper.<T>ioMainProgress(getView(), "加载中", false))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxTransformHelper.<T>ioMainException(getView()))
                .subscribe(onNext);

        disposableRaiser.add(disposable);
    }

    protected <T> void moduleExecute(@NonNull final Observable<T> observable, final Observer<T> onNext){
        observable.subscribeOn(Schedulers.io())
                .compose(RxTransformHelper.<T>ioMainProgress(getView(), "加载中", false))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext);
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void onDestroy(LifecycleOwner owner) {
        view.getLifecycle().removeObserver(this);
        view = null;
        module = null;
        disposableRaiser.clear();

        onPresenterDestroy();
    }


    /**
     * presenter绑定视图生命周期
     */
    private void bindLifcycle(){
            view.getLifecycle().addObserver(this);
    }


    //子类收尾清理方法
    abstract protected void onPresenterDestroy();


    protected void addDisposable(Disposable disposable){
        disposableRaiser.add(disposable);
    }



}
