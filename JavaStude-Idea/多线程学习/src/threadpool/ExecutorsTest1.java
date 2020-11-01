package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * author:吴云鹏
 * Date:2020/9/28
 * Time:21:59
 * 练习使用Executors获取ExecutorService,然后调用方法，提交任务
 */
public class ExecutorsTest1 {
    public static void main(String[] args) {
     //   test1();
        test2();
    }

    private static void test1() {
        //1 使用工厂类获取线程池对象
        ExecutorService es = Executors.newCachedThreadPool();
        //2 提交任务
        for (int i=1;i<=10;i++){
            es.submit(new MyRunnable(i));
        }
        es.shutdown();
    }
    private static void test2() {
        //1 使用工厂类获取线程池对象
        ExecutorService es = Executors.newCachedThreadPool(new ThreadFactory() {
            int n =1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程名称"+n++);
            }
        });
        //2 提交任务
        for (int i=1;i<=10;i++){
            es.submit(new MyRunnable(i));
        }
        es.shutdown();
    }
}

/**
 * 任务类 包含一个任务编号。在任务中，打印出是哪一个线程正在执行任务
 */
class My_Runnable implements Runnable{
    private int id;
    public My_Runnable(int id) {
        this.id = id;
    }
    @Override
    public void run() {
//       获取线程的名称，打印一句话
        String name = Thread.currentThread().getName();
        System.out.println(name+" 执行了任务......"+id);

    }
}
