package com.jz.frame.help.inter;

/**
 * @author jackzhous
 * @package com.jz.frame.help.inter
 * @filename PoolThread
 * date on 2019/5/28 5:02 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface PoolThread {

    /**
     * 提交任务
     * @param runnable
     */
    void submitTask(Runnable runnable);

}
