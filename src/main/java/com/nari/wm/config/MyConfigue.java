package com.nari.wm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

@Configuration
//@EnableAsync
public class MyConfigue implements AsyncConfigurer {

//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(10);
//        executor.setMaxPoolSize(30);
//        executor.setQueueCapacity(2000);
//        executor.initialize();
//        return executor;
//    }
}
