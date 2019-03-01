package com.jz.appframe.helper;

import android.util.Log;

import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.error.ApiException;
import com.jz.appframe.error.TokenExpiredException;
import com.jz.appframe.ui.LoginActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;


/**
 * Created by jackzhous on 2018/1/25.
 */

public class RxTransformHelper {


    /**
     * RxJava异常处理；默认情况下，rxjava不会自己解决任何一个异常，如果upstream产生异常，而downstream已经
     * 取消订阅，rxjava仍然会抛出异常，以下是事先设置处理异常
     */
    static {
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if(throwable instanceof ApiException){
                    Log.d("j_tag", "xxxx");
                }
            }
        });
    }

    /**
     * ObservableTransformer 类型转换器用来在订阅的同时完成
     * @param view
     * @param msg
     * @param canDismiss
     * @param <stream>
     * @return
     */
    public static <stream> ObservableTransformer<stream, stream> ioMainProgress(final CommView view, final String msg, final boolean canDismiss){
        return new ObservableTransformer<stream, stream>() {
            @Override
            public ObservableSource<stream> apply(Observable<stream> upstream) {
                return upstream.doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if(view != null)
                            view.showDialog(msg, canDismiss);
                    }
                }).doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        if(view != null)
                            view.closeDialog();
                    }
                });
            }
        };
    }

    /**
     * ObservableTransformer 类型转换器用来在订阅的同时完成
     * @param view
     * @param msgId
     * @param canDismiss
     * @param <stream>
     * @return
     */
    public static <stream> ObservableTransformer<stream, stream> ioMainProgress(final CommView view, final int msgId, final boolean canDismiss){
        return new ObservableTransformer<stream, stream>() {
            @Override
            public ObservableSource<stream> apply(Observable<stream> upstream) {
                return upstream.doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if(view != null)
                            view.showDialog(msgId, canDismiss);
                    }
                }).doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        if(view != null)
                            view.closeDialog();
                    }
                });
            }
        };
    }

    /**
     * 统一处理各类异常
     * @param view
     * @param <stream>
     * @return
     */
    public static <stream> ObservableTransformer<stream, stream> ioMainException(final CommView view){
        return new ObservableTransformer<stream, stream>() {
            @Override
            public ObservableSource<stream> apply(Observable<stream> upstream) {
                return upstream.doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(view != null)
                            view.showMessage(throwable.getMessage());
                        if (throwable instanceof ApiException) {
//                            ApiException apiException = (ApiException) throwable;
                           // view.showMessage(apiException.getMessage());
                        } else if (throwable instanceof TokenExpiredException) {
                            TokenExpiredException tokenExpiredException = (TokenExpiredException) throwable;
                            if(view != null){
                                view.showMessage(tokenExpiredException.getMessage());
                                view.gotoActivity(LoginActivity.class, false);
                            }

                        }
                        throwable.printStackTrace();
                    }
                });
            }
        };
    }

}
