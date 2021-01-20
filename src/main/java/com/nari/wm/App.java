package com.nari.wm;

import com.nari.wm.util.MyInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJms
public class App implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    // 选择性的重写
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new MyInterceptor());
        interceptor.addPathPatterns("/interceptor/*");
    }
}
