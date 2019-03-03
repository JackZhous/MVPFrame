package com.jz.appframe.data;

import com.jz.appframe.data.local.LoginRequest;
import com.jz.appframe.data.remote.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.remote
 * @filename MainService
 * date on 2019/3/3 6:54 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface MainService {
    @POST("xyyc/app/")
    Observable<LoginResponse> login(@Body LoginRequest request);
}
