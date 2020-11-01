package forkjoinmode;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @ author:吴云鹏@Date:2020/10/25 - Time:13:31
 * @ DESCRIPTION
 */
/*ForkJoin框架实现(对于中小型数据的优势不明显），对于超过10亿以上的累加大约有30%的效率提升*/
public class TestForkJoin {
    @Test
    public void test(){
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
    }
    @Test
    public void test1(){
        Instant start = Instant.now();
        LongStream.rangeClosed(0,1000000000L).parallel().reduce(0,Long::sum);
        Instant end=Instant.now();
        System.out.println("耗费时间为："+ Duration.between(start,end).toMillis());

    }

}
