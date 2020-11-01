package threadpool;

import java.util.concurrent.*;

/**
 *@ author:吴云鹏@Date:2020/10/9 - Time:12:13
 * @ DESCRIPTION 练习获取异步计算结果
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        1 获取线程池对象
        ExecutorService es = Executors.newCachedThreadPool();
//        2 创建Callable类型的任务对象
        Future<Integer> f = es.submit(new MyCall(1, 1));
//        判断任务是否已经完成
//        test1(f);
        boolean b = f.cancel(true);
//        System.out.println("取消任务执行的结果："+b);
        /*Integer v = f.get(1, TimeUnit.SECONDS);
        由于等待时间过短，任务来不及完成，会报异常
        System.out.println("任务执行的结果是："+v);*/
    }

    private static void test1(Future<Integer> f) throws InterruptedException, ExecutionException {
        boolean done = f.isDone();
        System.out.println("第一次判断任务是否完成："+done);
        boolean cancelled = f.isCancelled();
        System.out.println("第一次判断任务是否已经取消："+cancelled);
        Integer v = f.get();//一直等待结果，直到完成为止
        System.out.println("任务执行的结果是："+v);
        boolean done1 = f.isDone();
        System.out.println("第二次判断任务是否完成："+done1);
        boolean cancelled1 = f.isCancelled();
        System.out.println("第二次判断任务是否已经取消："+cancelled1);
    }
}
class MyCall implements Callable<Integer> {
    private int a;
    private int b;

    public MyCall(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name+"准备开始计算：");
        Thread.sleep(2000);
        System.out.println(name+"计算完成！");
        return a+b;

    }
}




