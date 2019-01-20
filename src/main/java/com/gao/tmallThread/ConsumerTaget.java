package com.gao.tmallThread;

import java.util.concurrent.TimeUnit;

public class ConsumerTaget implements Runnable {
    private Tmall tmall;

    public ConsumerTaget(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void run() {
        System.out.println (Thread.currentThread ().getName () + "正在消费");
        while (true) {
            tmall.take ();
            try {
                TimeUnit.SECONDS.sleep (1L);
            } catch (InterruptedException e) {
            }

        }
    }

}