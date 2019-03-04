package com.jz.frame.config.data;

import com.google.gson.annotations.SerializedName;
import com.jz.frame.config.Constant;

/**
 * @author jackzhous
 * @package com.jz.frame.config.date
 * @filename HttpStatus
 * date on 2019/3/4 10:34 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class HttpStatus {
    @SerializedName("code")
    private int mCode;
    @SerializedName("message")
    private String mMessage;

    @SerializedName("operatorName")
    private String mOperatorName;

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public String getOperatorName() {
        return mOperatorName;
    }

    /**
     * API是否请求失败
     *
     * @return 失败返回true, 成功返回false
     */
    public boolean isCodeInvalid() {
        return mCode != Constant.WEB_SUCCESS;
    }
}
