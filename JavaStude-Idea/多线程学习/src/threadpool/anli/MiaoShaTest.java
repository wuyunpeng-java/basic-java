package threadpool.anli;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ author:吴云鹏@Date:2020/10/11 - Time:11:19
 * @ DESCRIPTION 主程序类，测试任务类
 */
public class MiaoShaTest {
    public static void main(String[] args) {
//创建一个线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(15));
//循环创建任务对象
        for (int i = 1; i <=20 ; i++) {
            MyTask myTask = new MyTask("客户" + i);
            pool.submit(myTask);
        }
//        关闭线程池
        pool.shutdown();
    }
}
