package forkjoinmode;

import java.util.concurrent.RecursiveTask;

/**
 * @author 吴云鹏@Date:2020/10/25 - Time:12:21
 * @ DESCRIPTION
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private static final Long serialversionUID = 134656970968L;
    private static final Long THRESHOLD = 10000L;
    private Long start;
    private Long end;

    public ForkJoinCalculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long length = end - start;
        if (length <= THRESHOLD) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (end + start) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();//拆分子任务同时压入线程队列
            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}
