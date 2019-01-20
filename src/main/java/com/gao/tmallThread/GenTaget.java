package com.gao.tmallThread;

import java.util.concurrent.TimeUnit;

public class GenTaget implements Runnable {
    private Tmall tmall;

    public GenTaget(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void run() {
        System.out.println (Thread.currentThread ().getName () + "正在生产");
        while (true) {
            tmall.gen ();
            try {
                TimeUnit.SECONDS.sleep (1L);
            } catch (InterruptedException e) {
            }
        }

    }
}
