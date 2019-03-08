package com.jz.appframe.mvp.p;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jz.appframe.R;
import com.jz.appframe.adapter.TestAdapter;
import com.jz.appframe.mvp.m.ITestModule;
import com.jz.frame.dagger.scope.FragmentScope;
import com.jz.frame.mvp.p.BasePresenter;

import javax.inject.Inject;

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

    @Inject
    public TestPresenter(ITestModule module, TestBehavior.TestView view) {
        super(module, view);
    }

    @Override
    public void freshList() {

    }

    @Override
    public void initRecycle(EasyRecyclerView recyclerView,
                            RecyclerArrayAdapter.OnLoadMoreListener load,
                            SwipeRefreshLayout.OnRefreshListener fresh) {
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

    }

    @Override
    protected void onPresenterDestroy() {

    }
}
