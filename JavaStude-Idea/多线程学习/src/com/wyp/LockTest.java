package com.wyp;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ author:吴云鹏
 * Date:2020/4/3
 * Time:16:10
 * 解决线程安全问题的方式三 ---JDK5.0新增：Lock锁
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 100;
    /* 1 实例化ReentrantLock */
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            lock.lock();//调用锁定的方法
            if (ticket > 0) {

                System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                ticket--;
                lock.unlock();//调用解锁的方法；

            } else {
                break;
            }
        }
    }
}
