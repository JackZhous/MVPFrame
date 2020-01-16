package com.jz.appframe.mvp.p;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jz.appframe.R;
import com.jz.appframe.adapter.TestAdapter;
import com.jz.appframe.data.bean.Data;
import com.jz.appframe.helper.Config;
import com.jz.appframe.mvp.m.ITestModule;
import com.jz.frame.dagger.scope.FragmentScope;
import com.jz.frame.help.LogHelper;
import com.jz.frame.mvp.p.BaseObserver;
import com.jz.frame.mvp.p.BasePresenter;
import com.jz.frame.mvp.p.IResponse;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author jackzhous
 * @package com.jz.appframe.mvp.p
 * @filename TestPresenter
 * date on 2019/3/8 5:54 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@FragmentScope
public class TestPresenter extends BasePresenter<ITestModule, TestBehavior.TestView>
                                            implements TestBehavior.TestAction{
    @Inject
    TestAdapter adapter;


    private int cuurentPage = 0;    //当前页
    private int limit = 20;          //每页数量
    private int total = 0;

    @Inject
    public TestPresenter(ITestModule module, TestBehavior.TestView view) {
        super(module, view);
    }

    @Override
    public void freshList() {
        LogHelper.de_i("freshList");
        cuurentPage++;
        super.moduleExecute(getModule().loadList(limit, cuurentPage), new IResponse<Data>() {
            @Override
            public void GetResponse(Data data) {
                total++;
                adapter.add(data);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void initRecycle(EasyRecyclerView recyclerView,
                            RecyclerArrayAdapter.OnLoadMoreListener load,
                            SwipeRefreshLayout.OnRefreshListener fresh) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getView().getActivity(),
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
