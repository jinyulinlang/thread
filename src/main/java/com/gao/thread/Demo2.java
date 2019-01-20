package com.gao.thread;


import java.util.concurrent.ExecutorService;

import static java.lang.Thread.*;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class Demo2 {
    private volatile int signal;

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public static void main(String[] args) {
        ExecutorService executorService = newFixedThreadPool (3);
        Demo2 d = new Demo2 ();
//        线程修改
        executorService.execute (() -> {
            System.out.println (currentThread ().getName () + "修改线程的执行状态-----！");
            synchronized (d) {
                try {
                    sleep (20000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                d.setSignal (1);
                System.out.println (currentThread ().getName () + "修改状态执行完毕----!");
                d.notify ();
            }
        });
        executorService.execute (() -> {
            System.out.println (currentThread ().getName () + "开始监听线程-----！");
            synchronized (d) {
                while (d.getSignal () != 1) {
                    try {
                        d.wait ();
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }
                System.out.println (currentThread ().getName () + "监听线程执行完毕执行完毕----!");
            }
        });
//        线程监听
        executorService.shutdown ();
    }

}
