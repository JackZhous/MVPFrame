package com.jz.appframe.helper;

/**
 * @author jackzhous
 * @package com.jack.util
 * @filename Args
 * date on 2019/2/20 9:53 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class Args {

    public static void empty(Object obj, String msg){
        if(obj == null){
            throw new IllegalArgumentException(msg + "may not null");
        }
    }

    public static void positive(int number, String msg){
        if(number <= 0){
            throw new IllegalStateException(msg + "may not positive");
        }
    }

}
