package com.gao.conditon;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Demo2 {
    private int sigal;
    Lock lock = new ReentrantLock ();
    Condition a = lock.newCondition ();
    Condition b = lock.newCondition ();
    Condition c = lock.newCondition ();


    public void a() {
        lock.lock ();
        while (sigal != 0) {
            try {
                a.await ();
                TimeUnit.SECONDS.sleep (3L);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (Thread.currentThread ().getName () + "----a----");
        sigal++;
        b.signal ();
        lock.unlock ();
    }

    public void b() {
        lock.lock ();
        while (sigal != 1) {
            try {
                b.await ();
                TimeUnit.SECONDS.sleep (3L);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (Thread.currentThread ().getName () + "----b----");
        sigal++;
        c.signal ();
        lock.unlock ();
    }

    public void c() {
        lock.lock ();
        while (sigal != 2) {
            try {
                c.await ();
                TimeUnit.SECONDS.sleep (3L);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (Thread.currentThread ().getName () + "----c----");
        sigal = 0;
        a.signal ();
        lock.unlock ();
    }

    static class A implements Runnable {
        private Demo2 demo;

        public A(Demo2 demo) {
            this.demo = demo;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    demo.a ();
                    TimeUnit.SECONDS.sleep (1L);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    static class C implements Runnable {
        private Demo2 demo;

        public C(Demo2 demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    demo.c ();
                    TimeUnit.SECONDS.sleep (1L);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    static class B implements Runnable {
        private Demo2 demo;

        public B(Demo2 demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    demo.b ();
                    TimeUnit.SECONDS.sleep (1L);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo2 demo = new Demo2 ();
        A a = new A (demo);
        B b = new B (demo);
        C c = new C (demo);
        new Thread (a).start ();
        new Thread (b).start ();
        new Thread (c).start ();
    }
}
