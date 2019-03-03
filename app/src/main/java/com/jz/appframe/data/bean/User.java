package com.jz.appframe.data.bean;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.local
 * @filename User
 * date on 2019/3/3 5:48 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class User {

    private String token;
    private String message;

    public User(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
