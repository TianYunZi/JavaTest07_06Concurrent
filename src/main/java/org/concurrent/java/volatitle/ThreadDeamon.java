package org.concurrent.java.volatitle;

/**
 * Created by XJX on 2017/4/3.
 */
public class ThreadDeamon implements Runnable {

    private volatile boolean flag = false;

    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
