package org.concurrent.java.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by XJX on 2017/4/5.
 * <p>
 * CountDownLatch ：闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行.
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(100);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    for (int m = 0; m < 50000; m++) {
                        if (m % 2 == 0) {
                            System.out.println(m);
                        }
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("耗费时间为：" + end);
    }
}
