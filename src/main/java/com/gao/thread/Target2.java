package com.gao.thread;

import static java.lang.Thread.currentThread;

public class Target2 implements Runnable {
    private Demo demo;

    public Target2(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        System.out.println (currentThread ().getName () + "获得的信息号是" + demo.getSignal ());
    }
}
