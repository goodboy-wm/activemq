package com.nari.wm.brl.impl;

import com.nari.wm.brl.ThreadPoolService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {


    @Override
    @Async
    public void printHello() {
        String threadName = Thread.currentThread().getName();
        System.out.println("执行任务的线程："+threadName);
    }

}
