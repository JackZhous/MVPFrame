package com.jz.frame.dagger.module;

import com.jz.frame.config.service.IServiceCreator;
import com.jz.frame.config.NetConfig;
import com.jz.frame.config.service.ServiceCreator;
import com.jz.frame.config.parse.CustomGsonConverterFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author jackzhous
 * @package com.jz.frame.dagger.module
 * @filename MyAppModule
 * date on 2019/3/4 9:32 AM
 * @describe
 * MyAppModule用于向整个App提供的单利实例，网络、App等
 * @email jackzhouyu@foxmail.com
 **/
@Module
public abstract class MyAppModule {


    //网络底层服务
    @Binds
    abstract IServiceCreator serviceCreator(ServiceCreator serviceCreator);

    //底层retrofit
    @Singleton
    @Provides
    static Retrofit provideRetrofit(NetConfig config){
        OkHttpClient client;

        if(config.getClient() != null){
            client = config.getClient();
        }else {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(config.getTimeout(), config.getUnit());
            builder.connectTimeout(config.getTimeout(), config.getUnit());

            for(Interceptor interceptor : config.getInterceptors()){
                builder.addInterceptor(interceptor);
            }

            client = builder.build();
        }


        return new Retrofit.Builder().baseUrl(config.getBaseUrl())
                .client(client)
                /**
                 * 设置自定义的GsonConverter,处理所有的API请求
                 * 检测请求返回的CODE字段,如果失败抛出异常
                 */
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


}
