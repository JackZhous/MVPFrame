package com.jz.frame.config.error;

import com.jz.frame.config.Constant;

/**
 * @author jackzhous
 * @package com.jz.frame.config.error
 * @filename ServiceException
 * date on 2019/3/4 10:37 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class ServiceException extends RuntimeException {
    private final int mErrorCode;
    private final String mExtra;

    public ServiceException(int errorCode, String errorMessage, String extra) {
        super(errorMessage);
        mErrorCode = errorCode;
        mExtra = extra;
    }

    /**
     * token是否过期; 由于此框架封装好后代码不可修改，所以给了个参数；
     * 有一个默认的token过期方法也可以调用
     * @param tokenExpriedCode 过期的code码
     * @return
     */
    public boolean isTokenExpried(int tokenExpriedCode) {
        return mErrorCode == tokenExpriedCode;
    }

    public boolean defaultIsTokenExpried(){
        return mErrorCode == Constant.TOKEN_EXPRIED;
    }


    public int getErrorCode() {
        return mErrorCode;
    }

    public String getExtra() {
        return mExtra;
    }
}
