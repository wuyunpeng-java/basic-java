package mapandreduce;

import bean.MyDate;
import bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;


/**
 *@ author:吴云鹏@Date:2020/10/23 - Time:11:18
 * @ DESCRIPTION
 * 用MAP和REDUCE方法分别数一数流中有多少个Employee?
 */
public class Reduce {
    public ArrayList<bean.Employee> list = new ArrayList<>();
    {Employee e1 = new Employee("刘德华", 55, new MyDate(1965, 6, 16));
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
        list.add(e8);}
    @Test
    public void test1(){
        Optional<Integer> count = list.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(count.get());
    }
}
