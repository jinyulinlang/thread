package com.gao.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo {
    private volatile int signal;

    public synchronized int getSignal() {
        System.out.println (Thread.currentThread ().getName () + "----getSignal方法执行了");
        if (signal != 1) {
            try {
                wait ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (Thread.currentThread ().getName () + "---getSignal方法执行完毕");
        return signal;
    }

    public synchronized void setSignal(int signal) {
        System.out.println (Thread.currentThread ().getName () + "----setSignal方法执行了");
        this.signal = signal;
        notifyAll ();
        System.out.println (Thread.currentThread ().getName () + "----setSignal方法完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo ();
//        new 一个线程池
        ExecutorService executorService = MyExecutors.newThreadPool ();
        executorService.execute (new Target (demo));
//        执行任务2
        executorService.execute (new Target2 (demo));
        TimeUnit.SECONDS.sleep (1L);
//        执行任务2
        executorService.execute (new Target2 (demo));
        TimeUnit.SECONDS.sleep (1L);
        executorService.shutdown ();
    }
}
