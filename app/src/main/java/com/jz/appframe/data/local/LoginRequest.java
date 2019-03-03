package com.jz.appframe.data.local;

import com.google.gson.annotations.SerializedName;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.local
 * @filename LoginRequest
 * date on 2019/2/20 4:43 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LoginRequest {

    @SerializedName("cmd")
    private final String cmd = "login20170303";
    @SerializedName("params")
    private final ParamBean params = new ParamBean();

    public LoginRequest() {

    }

    public LoginRequest(String phoneNum, String code, String channelId) {
        setMobile(phoneNum);
        setAuthCode(code);
        setChannelId(channelId);
    }

    public void setMobile(String mobile) {
        params.mobile = mobile;
    }

    public void setChannelId(String channelId) {
        params.channelId = channelId;
    }

    public void setAuthCode(String authCode) {
        params.authCode = authCode;
    }

    static class ParamBean {
        @SerializedName("deviceType")
        private String deviceType = "Android";
        @SerializedName("channelId")
        private String channelId;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("code")
        private String authCode;
    }
}
