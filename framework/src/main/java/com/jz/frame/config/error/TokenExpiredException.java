package com.jz.frame.config.error;

/**
 * @author jackzhous
 * @package com.jz.frame.config.error
 * @filename TokenExpiredException
 * date on 2019/3/4 11:27 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TokenExpiredException extends RuntimeException{

    public TokenExpiredException(String msg) {
        super(msg);
    }

}
