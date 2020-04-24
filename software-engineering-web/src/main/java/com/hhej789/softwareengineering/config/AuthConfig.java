package com.hhej789.softwareengineering.config;

import com.hhej789.softwareengineering.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName AuthConfig
 * @Description TODO
 * @Author AICHI
 * @Date 2020/4/23 21:45
 * @Version 1.0
 */

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor initAuthInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initAuthInterceptor()).addPathPatterns("").excludePathPatterns("/*");
    }
}
