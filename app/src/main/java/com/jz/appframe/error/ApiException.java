package com.jz.appframe.error;

import com.jz.appframe.helper.Config;

/**
 * @author jackzhous
 * @package com.jz.appframe.error
 * @filename ApiException
 * date on 2019/2/20 4:54 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class ApiException extends RuntimeException {
    private final int mErrorCode;
    private final String mExtra;

    public ApiException(int errorCode, String errorMessage, String extra) {
        super(errorMessage);
        mErrorCode = errorCode;
        mExtra = extra;
    }

    /**
     * 判断是否是token失效
     *
     * @return 失效返回true, 否则返回false;
     */
    public boolean isTokenExpried() {
        return mErrorCode == Config.TOKEN_EXPRIED;
    }


    public int getErrorCode() {
        return mErrorCode;
    }

    public String getExtra() {
        return mExtra;
    }
}

