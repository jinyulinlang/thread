package com.gao.conditon;

import java.util.concurrent.TimeUnit;

public class Demo {
    private int sigal;

    public synchronized void a() {
        while (sigal != 0) {
            try {
                wait ();
                TimeUnit.SECONDS.sleep (3L);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (Thread.currentThread ().getName () + "----a----");
        sigal++;
        notifyAll ();
    }

    public synchronized void b() {
        while (sigal != 1) {
            try {
                wait ();
                TimeUnit.SECONDS.sleep (3L);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (Thread.currentThread ().getName () + "----b----");
        sigal++;
        notifyAll ();
    }

    public synchronized void c() {
        while (sigal != 2) {
            try {
                wait ();
                TimeUnit.SECONDS.sleep (3L);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (Thread.currentThread ().getName () + "----c----");
        sigal = 0;
        notifyAll ();
    }

    static class A implements Runnable {
        private Demo demo;

        public A(Demo demo) {
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
        private Demo demo;

        public C(Demo demo) {
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
        private Demo demo;

        public B(Demo demo) {
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
        Demo demo = new Demo ();
        A a = new A (demo);
        B b = new B (demo);
        C c = new C (demo);
        new Thread (a).start ();
        new Thread (b).start ();
        new Thread (c).start ();
    }
}
