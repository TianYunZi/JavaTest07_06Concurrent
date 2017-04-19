package org.concurrent.java.cas;

/**
 * Created by XJX on 2017/4/4.
 */
public class CompareAndSwap {

    private int value;

    /**
     * 获取内存值.
     *
     * @return
     */
    public synchronized int getValue() {
        return value;
    }

    /**
     * 比较.
     *
     * @param expectValue
     * @param newValue
     * @return
     */
    private synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return expectValue == this.compareAndSwap(expectValue, newValue);
    }
}
