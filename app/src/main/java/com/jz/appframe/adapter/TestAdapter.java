package com.jz.appframe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jz.appframe.R;
import com.jz.appframe.data.bean.Data;
import com.jz.appframe.data.bean.TestBean;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author jackzhous
 * @package com.jz.appframe.adapter
 * @filename TestAdapter
 * date on 2019/3/8 6:21 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TestAdapter  extends RecyclerArrayAdapter<Data> {

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


    static class TestHolder extends BaseViewHolder<Data>{

        @BindView(R.id.img)
        ImageView iv_img;
        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_desc)
        TextView tv_desc;

        public TestHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(Data data) {
            Glide.with(getContext())
                    .load(data.getPic())
                    .into(iv_img);
            title.setText(data.getTitle());
            tv_desc.setText(data.getFoodStr());
        }
    }
}
