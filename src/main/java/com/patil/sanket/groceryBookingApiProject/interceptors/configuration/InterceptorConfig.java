package com.patil.sanket.groceryBookingApiProject.interceptors.configuration;

import com.patil.sanket.groceryBookingApiProject.interceptors.impl.RequestInterceptorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private RequestInterceptorImpl requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor).addPathPatterns("/v1/grocery/**");
            // adding double * is bcoz, if we have /v1/grocery/book, or /v1/grocery/path1/path2, etc.. so all such paths will be taken care
    }
}
