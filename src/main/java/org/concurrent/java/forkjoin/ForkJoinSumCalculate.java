package org.concurrent.java.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by XJX on 2017/4/9.
 */
public class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private static final long SerialVersionUid = 123456789L;

    private long start;
    private long end;

    private static final long THURSHOLD = 0L;//临界值

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if (end - start <= THURSHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, mid);
            left.fork();//进行拆分，同时压入线程队列
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(mid + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}
