package com.jz.frame.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author jackzhous
 * @package com.jz.frame.dagger.scope
 * @filename ActivityScope
 * date on 2019/3/4 9:32 AM
 * @describe 自定义注解类，实现和Activity的生命周期绑定
 * @email jackzhouyu@foxmail.com
 **/
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
