package com.jz.appframe.data.remote;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.remote
 * @filename LoginResponse
 * date on 2019/2/20 4:44 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LoginResponse extends BaseResponse {




    private String token;
    private String username;
    private int createTime;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }
}
