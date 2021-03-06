package org.concurrent.java.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by XJX on 2017/4/4.
 * * 一、i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”
 * int i = 10;
 * i = i++; //10
 * <p>
 * int temp = i;
 * i = i + 1;
 * i = temp;
 * <p>
 * 二、原子变量：在 java.util.concurrent.atomic 包下提供了一些原子变量。
 * 1. volatile 保证内存可见性
 * 2. CAS（Compare-And-Swap） 算法保证数据变量的原子性
 * CAS 算法是硬件对于并发操作的支持
 * CAS 包含了三个操作数：
 * ①内存值  V
 * ②预估值  A
 * ③更新值  B
 * 当且仅当 V == A 时， V = B; 否则，不会执行任何操作。
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo demo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo).start();
        }
    }
}

class AtomicDemo implements Runnable {

    //private volatile int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();

    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}
