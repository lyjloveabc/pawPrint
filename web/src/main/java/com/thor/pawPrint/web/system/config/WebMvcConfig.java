package com.thor.pawPrint.web.system.config;

import com.thor.pawPrint.web.system.interceptor.OpenIdInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 解决跨域
     *
     * @return 过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }

    @Bean
    public OpenIdInterceptor openIdInterceptor() {
        return new OpenIdInterceptor();
    }

    /**
     * 配置拦截器
     *
     * @param registry registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(openIdInterceptor()).addPathPatterns("/**");
    }

}
