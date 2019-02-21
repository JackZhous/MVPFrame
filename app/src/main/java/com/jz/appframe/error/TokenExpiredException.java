package com.jz.appframe.error;

/**
 * @author jackzhous
 * @package com.jz.appframe.error
 * @filename TokenExpiredException
 * date on 2019/2/21 10:11 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException(String msg) {
        super(msg);
    }
}

