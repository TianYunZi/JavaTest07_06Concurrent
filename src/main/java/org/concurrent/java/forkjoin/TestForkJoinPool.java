package org.concurrent.java.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

/**
 * Created by XJX on 2017/4/9.
 */
public class TestForkJoinPool {

    public static void main(String[] args) {

        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 10000000000L);
        Long sum = pool.invoke(task);
        System.out.println("总和:" + sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void testJdkeighth() {
        Instant start = Instant.now();

        long sum = 0L;

        sum = LongStream.rangeClosed(0L, 50000000000L).parallel().reduce(0L, Long::sum);

        long sum2 = LongStream.rangeClosed(0L, 50000000000L).parallel().reduce(0L, (left, right) -> {
            return Long.sum(left, right);
        });

        System.out.println("总和:" + sum);

        System.out.println("总和2:" + sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test() {

        Instant start = Instant.now();

        long sum = 0L;
        for (long i = 0L; i <= 50000000000L; i++) {
            sum += i;
        }

        System.out.println("总和:" + sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());

    }
}
