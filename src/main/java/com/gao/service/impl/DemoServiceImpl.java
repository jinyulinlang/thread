package com.gao.service.impl;

import com.gao.service.DemoService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    /**
     *
     */
    @Override
   @Async//支持异步调用
    public void a() throws InterruptedException {
        while (true) {
            System.out.println ("a----");
            Thread.sleep (2000);
        }
    }

    @Override
    @Async//支持异步调用
    public void b() throws InterruptedException {
        while (true) {
            System.out.println ("b----");
            Thread.sleep (2000);
        }
    }


}
