package basicThread;

import static java.lang.Thread.yield;

/**
 *测试Thread中的常用方法
 * 1 start()启动当前线程；调用当前线程的run方法；
 * 2 run()需要重写Thread类中的此方法；
 * 3 currentThread()方法：Thread类中的静态方法，返回正在执行当前代码的线程；
 * 4 getName() ;setName();
 * 5 yield() 释放当前线程的执行权；
 * 6 join();在线程A中调用线程B的join方法，线程A即进入阻塞状态。直到线程B执行完毕后，线程A才结束阻塞状态。
 *
 * @author 吴云鹏
 */

public class ThreadMethodTest {
    public static void main(String[] args) {
        Thread.currentThread().setName("我的主线程");
        yield();
        System.out.println("hello" +Thread.currentThread().getName());
    }
}
