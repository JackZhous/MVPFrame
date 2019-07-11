package com.jz.appframe.presenter;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jz.appframe.R;
import com.jz.appframe.adapter.TestAdapter;
import com.jz.appframe.data.bean.TestBean;
import com.jz.appframe.data.service.ModuleManager;
import com.jz.appframe.presenter.behavior.TestBehavior;
import com.jz.frame.help.LogHelper;
import com.jz.frame.mvp.p.BaseObserver;
import com.jz.frame.mvp.p.BasePresenter;


import io.reactivex.disposables.Disposable;

/**
 * @author jackzhous
 * @package com.jz.appframe.mvp.p
 * @filename TestPresenter
 * date on 2019/3/8 5:54 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TestPresenter extends BasePresenter<ModuleManager, TestBehavior.TestView>
                                            implements TestBehavior.TestAction{

    TestAdapter adapter;


    private int cuurentPage = 0;    //当前页
    private int limit = 20;          //每页数量
    private int total = 0;

    public TestPresenter(ModuleManager module) {
        super(module);
    }

    @Override
    public void freshList() {
        LogHelper.de_i("freshList");
        cuurentPage++;
        super.moduleExecute(getModule().freshList(limit, cuurentPage),
                                        new BaseObserver<TestBean>(getView()){

                                            @Override
                                            public void onNext(TestBean data) {
                                                total++;
                                                adapter.addAll(data.getData());
                                                adapter.notifyDataSetChanged();
                                            }

                                            @Override
                                            public void onSubscribe(Disposable d) {
                                                addDisposable(d);
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                super.onError(e);
                                            }

                                            @Override
                                            public void onComplete() {
                                                super.onComplete();

                                            }
                                        });
    }

    @Override
    public void initRecycle(EasyRecyclerView recyclerView,
                            RecyclerArrayAdapter.OnLoadMoreListener load,
                            SwipeRefreshLayout.OnRefreshListener fresh) {
        adapter = new TestAdapter(getView().getFragmentContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getView().getFragmentContext(),
                            LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapterWithProgress(adapter);

        adapter.setMore(R.layout.recycler_item_more, load);
        adapter.setNoMore(R.layout.recycler_item_nomore);
        adapter.setError(R.layout.recycler_item_error,
                new RecyclerArrayAdapter.OnErrorListener() {
                    @Override
                    public void onErrorShow() {

                    }

                    @Override
                    public void onErrorClick() {
//                        onRefresh();
                    }
                });

        recyclerView.setRefreshListener(fresh);
    }


    @Override
    public void freshFirst() {
        cuurentPage = 0;
        total = 0;
        adapter.clear();
        freshList();
    }

    @Override
    protected void onPresenterDestroy() {
        adapter = null;
    }
}
