package com.yuba.cafe.security;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthFilterConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(someFilter());
        registration.addUrlPatterns("/api/secure/*");
        registration.setName("authFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "someFilter")
    public Filter someFilter() {
        return new AuthFilter();
    }
}
