package org.concurrent.java.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by XJX on 2017/4/7.
 */
public class AlternateDemo {

    private int num = 1;//对当前线程进行标记

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     * 循环打印.
     *
     * @param totalLoop 第几轮
     */
    public void LoopA(int totalLoop) {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //唤醒
            num = 2;
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 循环打印.
     *
     * @param totalLoop 第几轮
     */
    public void LoopB(int totalLoop) {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //唤醒
            num = 3;
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 循环打印.
     *
     * @param totalLoop 第几轮
     */
    public void LoopC(int totalLoop) {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //唤醒
            num = 1;
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
