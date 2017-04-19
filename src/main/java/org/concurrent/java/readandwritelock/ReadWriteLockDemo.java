package org.concurrent.java.readandwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by XJX on 2017/4/8.
 */
public class ReadWriteLockDemo {

    private int num = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void getNum() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + num);
        } finally {
            lock.readLock().unlock();
        }
    }

    //写
    public void setNum(int num) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + num);
            this.num = num;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
