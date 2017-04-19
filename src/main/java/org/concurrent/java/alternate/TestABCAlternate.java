package org.concurrent.java.alternate;

/**
 * Created by XJX on 2017/4/7.
 */
public class TestABCAlternate {

    public static void main(String[] args) {
        final AlternateDemo demo = new AlternateDemo();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                demo.LoopA(i);
            }
        }, "线程A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                demo.LoopB(i);
            }
        }, "线程B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                demo.LoopC(i);
            }
        }, "线程C").start();
    }
}
