package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author:吴云鹏@Date:2020/10/5 - Time:17:13
 * @ DESCRIPTION 测试ScheduleExecutorService延时执行任务和定时执行任务的功能
 * -->延迟执行任务并间隔重复时间入门练习
 */
public class ScheduledExecutorService1 {
    public static void main(String[] args) {
//        获取一个可以延迟执行任务的线程池对象
        java.util.concurrent.ScheduledExecutorService es = Executors.newScheduledThreadPool(3
                , new ThreadFactory() {
                    int n=1;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r,"自定义线程名：" + n++);
                    }
                });
//        创建多个任务对象，提交任务，每个任务延迟执行
        es.scheduleAtFixedRate(new MyRunnable1(1),1, 2,TimeUnit.SECONDS);
        System.out.println("OVER");

    }
}

class MyRunnable1 implements Runnable{
private int id;
    public MyRunnable1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "执行了任务:"+id);

    }
}