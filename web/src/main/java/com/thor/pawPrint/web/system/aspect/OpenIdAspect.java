package com.thor.pawPrint.web.system.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 获取用户openId，设置到session
 * Created by Thor on 2017/2/18.
 * happy coding - 1203!
 */
//@Aspect
//@Component
@Slf4j
public class OpenIdAspect {
    //过滤器切入点
    @Pointcut("execution(* com.thor.pawPrint.web.system.filter.*.* (..))")
    public void sysFilterLogPointcut() {
    }

    //控制层切入点
    @Pointcut("execution(* com.thor.pawPrint.web.controller.*.*.* (..))")
    public void controllerLogPointcut() {
    }

}
