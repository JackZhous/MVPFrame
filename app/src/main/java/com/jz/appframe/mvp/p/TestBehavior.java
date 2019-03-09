package com.jz.appframe.mvp.p;

import android.support.v4.widget.SwipeRefreshLayout;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jz.frame.mvp.p.IPresenter;
import com.jz.frame.mvp.v.IActivityView;
import com.jz.frame.mvp.v.IFragmentView;
import com.jz.frame.mvp.v.IView;

/**
 * @author jackzhous
 * @package com.jz.appframe.mvp.p
 * @filename TestBehavior
 * date on 2019/3/8 5:52 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface TestBehavior {

    //动作发起
    interface TestAction extends IPresenter {

        /**
         * 刷新列表
         */
        void freshList();

        void freshFirst();

        void initRecycle(EasyRecyclerView recyclerView,
                         RecyclerArrayAdapter.OnLoadMoreListener load,
                         SwipeRefreshLayout.OnRefreshListener fresh);
    }

    //动作响应
    interface TestView extends IView, IFragmentView {
        void showRecycleStatus(byte status);
    }

}
