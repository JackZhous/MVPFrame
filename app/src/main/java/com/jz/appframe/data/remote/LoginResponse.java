package com.jz.appframe.data.remote;

import com.google.gson.annotations.SerializedName;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.remote
 * @filename LoginResponse
 * date on 2019/2/20 4:44 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class LoginResponse extends BaseResponse {

    @SerializedName("detail")
    private DetailBean detail;

    public DetailBean getDetail() {
        return detail;
    }

    public void setDetail(DetailBean detail) {
        this.detail = detail;
    }

    public static class DetailBean {
        @SerializedName("token")
        private String token;
        @SerializedName("user")
        private UserBean user;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            @SerializedName("id")
            private int id;
            @SerializedName("balance")
            private double balance;
            @SerializedName("user_name")
            private String userName;
            @SerializedName("name")
            private String name;
            @SerializedName("type")
            private int type;
            @SerializedName("mobile")
            private String mobile;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public double getBalance() {
                return balance;
            }

            public void setBalance(double balance) {
                this.balance = balance;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
        }
    }
}
