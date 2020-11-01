package functionalInterface;

import bean.Employee;
import bean.MyDate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * author:吴云鹏
 * Date:2020/5/10
 * Time:10:39
 * Stream的三个操作步骤:
 * 1 创建Stream；2 中间操作； 3 终止操作（终端输出）
 */
public class StreamAPITest1 {
   public  ArrayList<Employee> list = new ArrayList<>();

    {
        Employee e1 = new Employee("刘德华", 55, new MyDate(1965, 6, 16));
        Employee e2 = new Employee("zhangxueyou", 56, new MyDate(1965, 6, 19));
        Employee e3 = new Employee("liming", 57, new MyDate(1965, 1, 22));
        Employee e4 = new Employee("wiuyun", 51, new MyDate(1968, 3, 31));
        Employee e5 = new Employee("wanghaobo", 40, new MyDate(1979, 7, 19));
        Employee e6 = new Employee("ganhaobo", 41, new MyDate(1978, 6, 1));
        Employee e7 = new Employee("wanhaobo", 41, new MyDate(1978, 7, 1));
        Employee e8 = new Employee("zbnghaobo", 41, new MyDate(1978, 6, 1),Employee.Status.FREE);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        list.add(e7);
        list.add(e8);
    }

    @Test
    public void test1() {

        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getAge() >= 55).forEach(System.out::println);
        System.out.println();
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
        list.stream().distinct().forEach(System.out::println);


    }
    @Test
    public void test2(){
        Optional<Employee> op = list.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(op.get());

    }

}