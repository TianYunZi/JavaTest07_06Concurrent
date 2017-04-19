package org.concurrent.java.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by XJX on 2017/4/9.
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外开销，提高了响应的速度。
 * <p>
 * 二、线程池的体系结构：
 * java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 * |--**ExecutorService 子接口: 线程池的主要接口
 * |--ThreadPoolExecutor 线程池的实现类
 * |--ScheduledExecutorService 子接口：负责线程的调度
 * |--ScheduledThreadPoolExecutor ：继承 ThreadPoolExecutor， 实现 ScheduledExecutorService
 * <p>
 * 三、工具类 : Executors
 * ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 * ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
 * ExecutorService newSingleThreadExecutor() : 创建单个线程池。线程池中只有一个线程
 * <p>
 * ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务。
 */
public class TestThreadPool {

    private static int produceTaskSleep = 2;

    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 8, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>
                (3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 1; i < produceTaskMaxNumber; i++) {
            try {
                String task = "task@" + i;
                System.out.println("创建任务并提交到线程池中：" + task);
                executor.execute(() -> {
                    System.out.println("开始执行任务：" + task);
                });
            } finally {
                executor.shutdown();
            }
        }
    }
}
