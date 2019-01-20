package com.gao.tmallThread;

import com.gao.thread.MyExecutors;

import java.util.concurrent.ExecutorService;

public class TmallTest {
    public static void main(String[] args) {
        Tmall tmall = new Tmall ();
        GenTaget g = new GenTaget (tmall);
        ConsumerTaget c = new ConsumerTaget (tmall);
        ExecutorService executorService = MyExecutors.newThreadPool ();
        executorService.execute (g);
        executorService.execute (g);
        executorService.execute (c);
        executorService.execute (c);
//        executorService.shutdown ();
    }
}
