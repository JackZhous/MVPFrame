package com.jz.appframe.presen.base;

import com.jz.appframe.behavior.base.CommView;
import com.jz.appframe.data.DataManager;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author jackzhous
 * @package com.jz.appframe.presen.base
 * @filename BasePresenter
 * date on 2019/2/20 5:07 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class BasePresenter<T extends CommView> implements PresenterView<T> {
    private T view;

    //缓存响应者的引用
    protected CompositeDisposable disposableRaiser;

    //网络库API
    protected DataManager dataManager;

    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
        disposableRaiser = new CompositeDisposable();
    }

    public T getView() {
        return view;
    }

    @Override
    public void attach(T view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
        if (disposableRaiser != null && !disposableRaiser.isDisposed()){
            disposableRaiser.clear();
        }
    }
}
