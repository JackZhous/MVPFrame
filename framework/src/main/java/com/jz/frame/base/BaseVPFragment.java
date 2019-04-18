package com.jz.frame.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jz.frame.help.LogHelper;

/**
 * @author jackzhous
 * @package com.jz.frame.base
 * @filename BaseVPFragment
 * date on 2019/4/18 11:46 AM
 * @describe TODO
 * viewPager+Fragment模式建议继承该BaseFragment，
 * 防止Fragment重复刷新，真正做到懒加载，即所见即所得
 * 基本概念：
 * 1. setUserVisibleHint 方法调用时机先于Fragment的onCreate和onCreateView
 * 2. 第一次调用setUserVisibleHint方法参数会是false，最终会显示true
 * 3. fragment切换时，如果相邻两个Fragment已经存在（切换过），再次对他们来回切换不会掉用
 *    Fragment的生命周期函数，只会调用setUserVisibleHint
 * @email jackzhouyu@foxmail.com
 **/
public abstract class BaseVPFragment extends Fragment {

    private View rootView;                              //根布局视图
    private boolean hasFragmentVisible = false;         //Fragment是否可见 onCreateView执行后对齐赋值
    private boolean isUserVisable = false;              //setUserVisibleHint的参数保存
    /**
     * 提供布局文件
     * @return
     */
    protected abstract int layoutId();

    /**
     * 初始化布局内容
     * @param view
     */
    protected abstract void initView(View view);


    /**
     * fragment显示时调用，掩藏时没必要回调，掩藏状态的Fragment可能会被复用
     */
    protected abstract void onFragmentShow();


    /**
     * Fragment被销毁，用于清楚Fragment的一些状态
     */
    protected abstract void onDesView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView == null){
            rootView = LayoutInflater.from(getActivity()).inflate(layoutId(), container, false);
        }
        initView(rootView);

        /** -------- 处理点击显示的Fragment回调，也就是指哪儿显示哪儿的那个fragment -----------
         * isUserVisable为true说明setUserVisibleHint已经调用，且真的是要显示了
         * 回调即可
         */
        if(isUserVisable && getUserVisibleHint()){
            onFragmentShow();
        }
        hasFragmentVisible = true;
        return rootView;
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isUserVisable = isVisibleToUser;

        //false为掩藏状态，系统调用时没有问题，可以直接反馈
        if(!isVisibleToUser){
            //更新Fragment状态
            hasFragmentVisible = false;
            return;
        }

        /** -------- 处理相邻Fragment回调 -----------
         * 这个用于相邻Fragment，比如相邻AB，当前显示A，在显示A的时候B的onCreateView也会执行，
         * 但是isVisibleToUser为false，所以提前在hasFragmentVisible方法中更新状态，真正显示的时候
         * 当前方法参数为true，就直接回调onFragmentVisible -- true
         */
        if(hasFragmentVisible){
            onFragmentShow();
            hasFragmentVisible = true;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onDesView();
    }
}
