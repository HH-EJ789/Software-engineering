package com.hhej789.softwareengineering.config;

import com.hhej789.softwareengineering.interceptor.AuthInterceptor_hej;
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
public class AuthConfig_hej implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor_hej initAuthInterceptor() {
        return new AuthInterceptor_hej();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initAuthInterceptor()).addPathPatterns("").excludePathPatterns("/*");
    }
}
