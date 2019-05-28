package com.jz.frame.help;

import com.jz.frame.help.inter.PoolThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jackzhous
 * @package com.jz.frame.help
 * @filename ThreadHelper
 * date on 2019/5/28 5:02 PM
 * @describe 线程池辅助类，App所有创建线程由此现场操作
 * 1. 使用内部静态类实现,多线程安全，类加载器是单线程的，第一次加载ThreadHelper时不会实例化，
 * 只有在getInstance时才会创建，节省资源（为什么getInstance才会创建，而类加载器加载ThreadHelper时不创建内部类，
 * easy，类加载器加载的是ThreadHelper而不是Holder所以就不创建）
 * 2. 饿汉模式也能够保证多线程安全，只是类加载器第一次加载时就会创建，如果迟迟不使用这个类就会造成资源浪费
 * @email jackzhouyu@foxmail.com
 **/
public class ThreadHelper implements PoolThread {

    private ExecutorService cachedPool;

    private ThreadHelper() {
        cachedPool = Executors.newCachedThreadPool();
    }

    @Override
    public void submitTask(Runnable runnable) {
        cachedPool.submit(runnable);
    }

    public static ThreadHelper getInstnce(){
        return Holder.helper;
    }

    /**
     * 静态内部类实现单利模式
     */
    private static class Holder {
        private static ThreadHelper helper = new ThreadHelper();
    }
}
