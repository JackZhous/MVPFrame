package com.jz.appframe.data.net;

import android.content.Context;

import com.jz.appframe.data.local.LoginRequest;
import com.jz.appframe.data.remote.LoginResponse;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.net
 * @filename Apis
 * date on 2019/2/20 4:48 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface Apis {


    @POST("app")
    Observable<LoginResponse> login(@Body LoginRequest request);



    String ENDPOINT = "http://www.baidu.com";
    final class Factory {
        static OkHttpClient client;

        private Factory() {

        }

        public static Apis createService() {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(25, TimeUnit.SECONDS);
            builder.connectTimeout(25, TimeUnit.SECONDS);


            client = builder.build();

            Retrofit retrofit =
                    new Retrofit.Builder().baseUrl(Apis.ENDPOINT)
                            .client(client)
                            /**
                             * 设置自定义的GsonConverter,处理所有的API请求
                             * 检测请求返回的CODE字段,如果失败抛出异常
                             */
                            .addConverterFactory(CustomGsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();

            return retrofit.create(Apis.class);
        }

    }

}
