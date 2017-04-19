package org.concurrent.java.volatitle;

/**
 * Created by XJX on 2017/4/3.
 *
 * <p>一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 相较于 synchronized 是一种较为轻量级的同步策略。
 *
 * <p>注意：
 * 1. volatile 不具备“互斥性”
 * 2. volatile 不能保证变量的“原子性”
 */
public class ThreadMain {

    /**s
     * 启动函数.
     * @param args 参数
     */
    public static void main(String[] args) {
        ThreadDeamon deamon = new ThreadDeamon();
        Thread thread = new Thread(deamon);
        thread.start();

        while (true) {
            /*synchronized (deamon) {
                if (deamon.isFlag()) {
                    System.out.println("----------------------end-----------------------");
                    break;
                }
            }*/
            if (deamon.isFlag()) {
                System.out.println("----------------------end-----------------------");
                break;
            }
        }
    }
}
