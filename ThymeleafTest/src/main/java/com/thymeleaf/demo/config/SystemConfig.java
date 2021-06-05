package com.thymeleaf.demo.config;

import com.thymeleaf.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SystemConfig implements WebMvcConfigurer {
    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //拦截所有亲贵
                .addPathPatterns("/**")
                //放行的方法
                .excludePathPatterns("/login/**");
    }
}
