package com.jz.appframe.data.service;

import com.jz.appframe.data.bean.TestBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestService {
    @GET("/ios/cf/dish_list.php?stage_id=1")
    Observable<TestBean> loadImg(@Query("limit") int limit, @Query("page") int page);
}
