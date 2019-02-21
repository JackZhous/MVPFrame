package com.jz.appframe.data.local;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.local
 * @filename LoginRequest
 * date on 2019/2/20 4:43 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LoginRequest {

    private String username;

    private String passwd;

    public LoginRequest(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
