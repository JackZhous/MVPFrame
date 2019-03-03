package com.jz.appframe.dagger.module;

import com.jz.appframe.MyApplication;
import com.jz.appframe.data.IServiceCreator;
import com.jz.appframe.data.ServiceCreator;
import com.jz.appframe.data.net.CustomGsonConverterFactory;
import com.jz.appframe.data.net.NetConfig;

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
 * @package com.jz.appframe.dagger.module
 * @filename ApplicationModule
 * date on 2019/3/1 11:43 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
@Module
public abstract class ApplicationModule {


    @Singleton
    @Provides
    static Retrofit provideRetrofit(NetConfig config){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(config.getTimrout(), config.getUnit());
        builder.connectTimeout(config.getTimrout(), config.getUnit());

        for(Interceptor interceptor : config.getInterceptors()){
            builder.addInterceptor(interceptor);
        }

        OkHttpClient client = builder.build();

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


    @Binds
    abstract IServiceCreator bindServiceCreator(ServiceCreator creator);

}
