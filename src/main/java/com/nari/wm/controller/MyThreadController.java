package com.nari.wm.controller;

import com.nari.wm.brl.ThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyThreadController {
    @Autowired
    ThreadPoolService poolService;

    @GetMapping(value = "/printThread")
    public void printThread(){
        String name = Thread.currentThread().getName();
        System.out.println("执行控制器方法的线程名:"+name);
        poolService.printHello();
    }

}
