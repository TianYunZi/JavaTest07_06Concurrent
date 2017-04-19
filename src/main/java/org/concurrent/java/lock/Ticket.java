package org.concurrent.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by XJX on 2017/4/5.
 */
public class Ticket implements Runnable {

    private int ticket = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + --ticket);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
