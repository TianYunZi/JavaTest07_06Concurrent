package org.concurrent.java.readandwritelock;

/**
 * Created by XJX on 2017/4/8.
 * 写写/读写 需要“互斥”
 * 读读 不需要互斥
 */
public class TestReadWriteLock {
    public static void main(String[] args) {

        final ReadWriteLockDemo demo = new ReadWriteLockDemo();

        //写锁
        new Thread(() -> {
            demo.setNum((int) (Math.random() * 101));
        }, "写线程").start();

        //读锁
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                demo.getNum();
            }, "读线程" + i).start();
        }

    }
}
