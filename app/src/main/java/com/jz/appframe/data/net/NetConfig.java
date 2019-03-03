package com.jz.appframe.data.net;

import com.jz.appframe.helper.LogHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.net
 * @filename NetConfig
 * date on 2019/3/3 5:20 PM
 * @describe
 * 网络配置类
 * @email jackzhouyu@foxmail.com
 **/
public class NetConfig {

    private String baseUrl;

    private long timrout;

    private TimeUnit unit;

    private List<Interceptor> interceptors;

    NetConfig(String baseUrl, long timrout, TimeUnit unit, List<Interceptor> interceptors) {
        this.baseUrl = baseUrl;
        LogHelper.de_i("url " + baseUrl);
        this.timrout = timrout;
        this.unit = unit;
        this.interceptors = interceptors;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public long getTimrout() {
        return timrout;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public static class Builder {
        private String url;

        int port;

        String schmes;

        private long timeOut;

        private TimeUnit unit;

        private List<Interceptor> interceptors;

        public Builder() {
            schmes = "http://";
            port = 80;
            unit = TimeUnit.MILLISECONDS;
            interceptors = new ArrayList<>();
            timeOut = 10000;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setSchmes(String schmes) {
            this.schmes = schmes;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor){
            interceptors.add(interceptor);
            return this;
        }

        public Builder setTimeout(long timeOut){
            this.timeOut = timeOut;
            return this;
        }

        public Builder setUnit(TimeUnit unit) {
            this.unit = unit;
            return this;
        }

        public NetConfig build(){
            String url = schmes + this.url + ":" + port + "/";

            return new NetConfig(url, timeOut, unit, interceptors);
        }

    }


}
