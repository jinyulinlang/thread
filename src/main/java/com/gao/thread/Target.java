package com.gao.thread;


import java.util.concurrent.*;

import static java.lang.Thread.currentThread;

public class Target implements Runnable {
    private Demo demo;

    public Target(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        System.out.println (currentThread ().getName () + "开始设值");
        demo.setSignal (1);
    }
}
