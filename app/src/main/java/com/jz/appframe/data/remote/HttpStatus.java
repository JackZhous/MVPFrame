package com.jz.appframe.data.remote;

import com.google.gson.annotations.SerializedName;
import com.jz.appframe.helper.Config;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.remote
 * @filename HttpStatus
 * date on 2019/2/20 4:53 PM
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
        return mCode != Config.WEB_RESP_CODE_SUCCESS;
    }
}
