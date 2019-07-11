package com.jz.appframe.data.service;


import com.jz.appframe.data.bean.Data;
import com.jz.appframe.data.bean.TestBean;
import com.jz.appframe.data.local.LoginRequest;
import com.jz.appframe.data.remote.LoginResponse;
import com.jz.frame.config.NetConfig;
import com.jz.frame.config.parse.CustomGsonConverterFactory;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    @GET("/ios/cf/dish_list.php?stage_id=1")
    Observable<TestBean> freshList(@Query("limit") int limit, @Query("page") int page);

    @POST("xyyc/app/")
    Observable<LoginResponse> login(@Body LoginRequest request);


    class Factory{

        static ApiService service;

        public Factory() {
        }

        public static ApiService getService(NetConfig config){
            if(service != null){
                return service;
            }

            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(config.getTimeout(), config.getUnit());
            builder.connectTimeout(config.getTimeout(), config.getUnit());

            for(Interceptor interceptor : config.getInterceptors()){
                builder.addInterceptor(interceptor);
            }

            OkHttpClient client = builder.build();

            service = new Retrofit.Builder().baseUrl(config.getBaseUrl())
                    .client(client)
                    /**
                     * 设置自定义的GsonConverter,处理所有的API请求
                     * 检测请求返回的CODE字段,如果失败抛出异常
                     */
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(ApiService.class);

            return service;
        }

    }
}
