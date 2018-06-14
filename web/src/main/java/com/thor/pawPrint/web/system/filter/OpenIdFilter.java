package com.thor.pawPrint.web.system.filter;

import lombok.extern.slf4j.Slf4j;

/**
 * 微信用户访问本网站，获取他的openId，存到session中
 * Created by Thor on 2017/2/18.
 * happy coding - 1203!
 */
@Slf4j
//注释下面这个WebFilter注解，就可以关掉认证
//@WebFilter(filterName = "authenticationFilter", urlPatterns = {"*.do"})
public class OpenIdFilter {
}
