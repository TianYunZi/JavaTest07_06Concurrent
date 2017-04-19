package org.concurrent.java.cas;

import java.util.Random;

/**
 * Created by XJX on 2017/4/4.
 * 模拟CAS算法.
 */
public class TestCompareAndCwap {
    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap = new CompareAndSwap();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                int expectValue = compareAndSwap.getValue();
                boolean b = compareAndSwap.compareAndSet(expectValue, new Random().nextInt(101));
                System.out.println(b);
            }).start();
        }
    }
}
