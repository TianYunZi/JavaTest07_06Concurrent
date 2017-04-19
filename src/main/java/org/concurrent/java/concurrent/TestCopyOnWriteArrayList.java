package org.concurrent.java.concurrent;

/**
 * Created by XJX on 2017/4/4.
 * CopyOnWriteArrayList/CopyOnWriteArraySet : “写入并复制”
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择.
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();

        for (int i = 0; i < 100; i++) {
            new Thread(demo).start();
        }
    }
}
