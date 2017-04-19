package org.concurrent.java.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by XJX on 2017/4/5.
 * 一、创建执行线程的方式三：实现 Callable 接口。 相较于实现 Runnable 接口的方式，方法可以有返回值，并且可以抛出异常。
 * <p>
 * 二、执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。  FutureTask 是  Future 接口的实现类
 */
public class TestCallable {

    public static void main(String[] args) {

        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                sum += i;
            }
            return sum;
        });

        new Thread(task).start();

        try {
            Integer sum = task.get();
            System.out.println("和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
