package com.gao.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutors {

/*    public ThreadPoolExecutor(int corePoolSize, //	- 线程池核心池的大小。
                              int maximumPoolSize,  //	- 线程池的最大线程数。
                              long keepAliveTime,   //	- 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
                              TimeUnit unit,    //	 - keepAliveTime 的时间单位。
                              BlockingQueue<Runnable> workQueue,    //	 - 用来储存等待执行任务的队列。
                              ThreadFactory threadFactory,    //	- 线程工厂。
                              RejectedExecutionHandler handler) {
    }  //	 - 拒绝策略。*/

    public static ExecutorService newThreadPool(int nThreads) {
        return new ThreadPoolExecutor (nThreads, 2 * nThreads, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<> ());
    }

    public static ExecutorService newThreadPool() {
        return newThreadPool (3);
    }


}
