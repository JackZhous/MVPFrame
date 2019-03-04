package com.jz.appframe.data.service;

import com.jz.appframe.data.local.LoginRequest;
import com.jz.appframe.data.remote.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author jackzhous
 * @package com.jz.appframe.data
 * @filename UserService
 * date on 2019/3/3 5:03 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public interface UserService {


    @POST("xyyc/app/")
    Observable<LoginResponse> login(@Body LoginRequest request);

}
