package optional;

import bean.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @author:吴云鹏@Date:2020/10/29 - Time:20:34
 * @ DESCRIPTION
 */
public class TestOptional {
    /*Optional容器类的常用方法：
    1 optional.of(T t)-->创建一个optional实例
    2 optional.empty()-->创建一个空的optional实例
    3 optional.ofNullable(T t)-->若t不为null，则创建optional实例；否则，创建空实例
    4 isPresent()-->判断是否包含值
    5 orElseGet(Supplier s)-->如调用对象包含值则返回该值；否则返回s获取的值
    * */
    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(new Employee());
        System.out.println(op.get());
    }
    @Test
    public void test2(){
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }
    @Test
    public void  test3(){
        Optional<Employee> op = Optional.ofNullable(null);
        if (op.isPresent()){
            System.out.println(op.get());
        }else{
            Employee emp = op.orElseGet(() -> new Employee());
            System.out.println(emp);
        }

    }
}
