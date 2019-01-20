package com.gao.tmallThread;

public class Tmall {
    private int count;
    private final static int MAX_COUNT = 10;

    public synchronized void gen() {
        while (count >= MAX_COUNT) {
            try {
                System.out.println ("库存达到上限生产者停止生产！");
                wait ();
            } catch (InterruptedException e) {
            }
        }
        count++;
        System.out.println (Thread.currentThread ().getName () + "正在生产第" + count + "个产品");
        notifyAll ();
    }

    public synchronized void take() {
        while (count < 1) {
            try {
                wait ();
                System.out.println ("生产的产品不足停止消费！");
            } catch (InterruptedException e) {
            }
        }
        count--;
        System.out.println (Thread.currentThread ().getName () + "正在消费,当前库存剩余" + count + "个");
        notifyAll ();
//        System.out.println ("消费者消费后剩余" + count + "产品");
    }

    public int getCount() {

        return count;
    }
}
