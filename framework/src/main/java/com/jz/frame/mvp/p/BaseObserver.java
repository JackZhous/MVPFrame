package com.jz.frame.mvp.p;

import com.jz.frame.mvp.v.IView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 订阅工具类
 * @param <T>
 */
public class BaseObserver<T> implements Observer<T> {

    private IView view;

    public BaseObserver(IView view) {
        this.view = view;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        if(view != null){
            view.closeDialog();
        }
    }

    @Override
    public void onComplete() {
        if(view != null){
            view.closeDialog();
        }
    }
}
