package com.jz.appframe.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jz.appframe.R;
import com.jz.appframe.helper.Config;
import com.jz.appframe.helper.FactoryPresenter;
import com.jz.appframe.presenter.behavior.TestBehavior;
import com.jz.appframe.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * @author jackzhous
 * @package com.jz.appframe.ui.fragment
 * @filename TestFragment
 * date on 2019/3/8 5:40 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TestFragment extends BaseFragment<TestBehavior.TestAction>
                                            implements TestBehavior.TestView,
                                                        RecyclerArrayAdapter.OnLoadMoreListener,
                                                        SwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.recycler)
    EasyRecyclerView recyclerView;

    public TestFragment() {
    }

    @Override
    protected void initView(View view) {
        presenter.initRecycle(recyclerView, this, this);
    }

    @Override
    protected int provideLayout() {
        return R.layout.fragment_test;
    }



    @Override
    public void onRefresh() {
        presenter.freshFirst();
    }

    @Override
    public void onLoadMore() {
        presenter.freshList();
    }

    public static BaseFragment<TestBehavior.TestAction> newInstance(){
        return new TestFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.freshFirst();
    }

    @Override
    public void showRecycleStatus(byte status) {
        switch (status){
            case Config.STATUS_ERROR:
                recyclerView.showError();
                break;

            case Config.STATUS_NO_MORE:
                recyclerView.showEmpty();
        }
    }

    @Override
    protected TestBehavior.TestAction providePresenter() {
        return FactoryPresenter.getInstance().testPresenter();
    }
}
