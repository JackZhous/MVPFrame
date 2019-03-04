package com.jz.frame.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * @author jackzhous
 * @package com.jz.frame.config
 * @filename NetConfig
 * date on 2019/3/4 9:49 AM
 * @describe 网络连接库配置参数
 * 1. okhttp自定义则自己全部自定义，其他参数不允许配置
 * 2. OKHTTP默认，其他参数要配置
 * 1和2条件互斥
 * @email jackzhouyu@foxmail.com
 **/
public class NetConfig {

    private String baseUrl;

    private long timeout;

    private TimeUnit unit;

    private List<Interceptor> interceptors;

    private OkHttpClient client;

    NetConfig(String baseUrl, long timeout, TimeUnit unit,
                                    List<Interceptor> interceptors, OkHttpClient client) {
        this.baseUrl = baseUrl;
        this.timeout = timeout;
        this.unit = unit;
        this.interceptors = interceptors;
        this.client = client;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public long getTimeout() {
        return timeout;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public OkHttpClient getClient() {
        return client;
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
        private OkHttpClient client;

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

        public Builder setUnit(OkHttpClient unit) {
            this.client = unit;
            return this;
        }

        public NetConfig build(){
            String url = schmes + this.url + ":" + port + "/";

            return new NetConfig(url, timeOut, unit, interceptors , client);
        }

    }
}
