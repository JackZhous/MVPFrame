package com.jz.frame.mvp.p;

import com.jz.frame.config.error.ServiceException;
import com.jz.frame.config.error.TokenExpiredException;
import com.jz.frame.mvp.v.IView;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 订阅工具类
 * @param <T>
 */
public class BaseObserver<T> implements Observer<T> {

    private IView view;
    private CompositeDisposable myDisposable;
    private Disposable d;

    public BaseObserver(IView view, CompositeDisposable disposable) {
        this.view = view;
        myDisposable = disposable;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable throwable) {
        if(view != null)
            view.showMessage(throwable.getMessage());
        if (throwable instanceof ServiceException) {
//                            ApiException apiException = (ApiException) throwable;
            // view.showMessage(apiException.getMessage());
        } else if (throwable instanceof TokenExpiredException) {
            TokenExpiredException tokenExpiredException = (TokenExpiredException) throwable;
            if(view != null){
                view.showMessage(tokenExpiredException.getMessage());
                view.gotoActivity(null);
            }

        }
        throwable.printStackTrace();
        removeDisp();
    }

    @Override
    public void onComplete() {
        removeDisp();
    }

    private void removeDisp(){
        myDisposable.remove(d);
        myDisposable = null;
        if(view != null){
            view.closeDialog();
            view = null;
        }
    }
}
