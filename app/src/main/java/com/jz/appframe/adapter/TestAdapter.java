package com.jz.appframe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jz.appframe.R;
import com.jz.appframe.data.bean.TestBean;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author jackzhous
 * @package com.jz.appframe.adapter
 * @filename TestAdapter
 * date on 2019/3/8 6:21 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TestAdapter  extends RecyclerArrayAdapter<TestBean> {

    @Inject
    public TestAdapter(Context context) {
        super(context);
    }

    @Override
    public TestHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_test, parent,
                        false);
        return new TestHolder(view);
    }


    static class TestHolder extends BaseViewHolder<TestBean>{

        public TestHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(TestBean data) {
            super.setData(data);
        }
    }
}
