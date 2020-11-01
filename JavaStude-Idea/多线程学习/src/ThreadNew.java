import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**创建线程的方式三：实现Callable接口的方式。---JDK5.0新增
 *@ author:吴云鹏
 * Date:2020/4/3
 * Time:22:53
 * 步骤1：创建Callable接口的实现类；
 * 2:实现Call方法，将此线程要执行的操作声明在call()中；
 * 3：创建Callable接口实现类的对象--FutureTask；
 * 4：将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象;
 * 5：将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象并start;
 * 6: 获取Callable中Call方法的返回值；
 * 三大优势：1，有返回值；2：可以在方法体处抛出异常；3：支持泛型；
 */
public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        new Thread(futureTask).start();
        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class NumThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=1;i<100;i++){
            if (i % 2 ==0){
                System.out.println(i);
                sum +=i;
            }
        }
        return sum;
    }
}
