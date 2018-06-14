package com.thor.pawPrint.web.system.aspect;

import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.utils.console.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    private static final String START_LOG;
    private static final String END_LOG;

    private static final String METHOD_NAME_LABEL = "方法: ";
    private static final String METHOD_PARAM_LABEL = "参数: ";
    private static final String IP_LABEL = "请求来源真实IP: ";
    private static final String RETURN_LABEL = "返回值: ";

    //类加载的时候初始化全局变量
    static {
        START_LOG = "LOG START ………………………………";
        END_LOG = "LOG END.";
    }

    //过滤器切入点
    @Pointcut("execution(* com.thor.pawPrint.web.system.filter.*.* (..))")
    public void sysFilterLogPointcut() {
    }

    //控制层切入点
    @Pointcut("execution(* com.thor.pawPrint.web.controller.*.*.* (..))")
    public void controllerLogPointcut() {
    }

    //过滤器请求打印
    @Around("sysFilterLogPointcut()")
    public Object sysFilterLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info(START_LOG);
        log.info(METHOD_NAME_LABEL + proceedingJoinPoint.getSignature().toString());

        Object object = proceedingJoinPoint.proceed();

        log.info(END_LOG);

        return object;
    }

    //控制层请求打印
    @Around("controllerLogPointcut()")
    public Object controllerLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        PrintUtil.printEmptyLine();

        log.info(START_LOG);
        //log.info(IP_LABEL + IpUtil.getIpAddressSimple(httpServletRequest));
        log.info(METHOD_NAME_LABEL + proceedingJoinPoint.getSignature().toString());
        log.info(METHOD_PARAM_LABEL + Arrays.toString(proceedingJoinPoint.getArgs()));

        Object object = proceedingJoinPoint.proceed();

        log.info(RETURN_LABEL + String.valueOf(object));
        log.info(END_LOG + Constant.SPLIT_STR_NEW_LINE);

        return object;
    }

}
