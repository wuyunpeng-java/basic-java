package threadpool;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author:吴云鹏@Date:2020/10/5 - Time:17:13
 * @ DESCRIPTION 测试ScheduleExecutorService延时执行任务和定时执行任务的功能
 * -->延迟执行任务入门练习
 */
public class ScheduledExecutorService {
    public static void main(String[] args) {
//        获取一个可以延迟执行任务的线程池对象
        java.util.concurrent.ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
//        创建多个任务对象，提交任务，每个任务延迟执行
        es.schedule(new MyRunnable(1),2, TimeUnit.SECONDS);
        System.out.println("OVER");

    }
}

class MyRunnable implements Runnable{
private int id;
    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行了任务:"+id);

    }
}