package exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * author:吴云鹏
 * Date:2020/4/12
 * Time:13:20
 * 创建该类的5个对象并放入TreeSet集合中，
 * 1）使Employee实现Comparable接口，并按name排序；
 * 2）创建TreeSet时传入Comparator对象，按生日日期的先后排序；
 */
public class EmployeeTest {
    //使用自然排序
    @Test
    public void test2() {
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("刘德华", 55, new MyDate(1965, 6, 16));
        Employee e2 = new Employee("zhangxueyou", 56, new MyDate(1965, 6, 19));
        Employee e3 = new Employee("liming", 57, new MyDate(1965, 1, 22));
        Employee e4 = new Employee("wiuyun", 51, new MyDate(1968, 3, 31));
        Employee e5 = new Employee("wanghaobo", 40, new MyDate(1979, 7, 19));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        System.out.println(set);
        Iterator<Employee> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void test3() {
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBitthday();
                MyDate b2 = o2.getBitthday();
                int minusYear = b1.getYear() - b2.getYear();
                if (minusYear != 0) {
                    return minusYear;
                }
                int minusMonth = b1.getMonth() - b2.getMonth();
                if (minusMonth != 0) {
                    return minusMonth;
                }
                return b1.getDay() - b2.getDay();
            }
        });
        Employee e1 = new Employee("刘德华", 55, new MyDate(1965, 5, 16));
        Employee e2 = new Employee("zhangxueyou", 56, new MyDate(1965, 5, 19));
        Employee e3 = new Employee("liming", 57, new MyDate(1965, 1, 22));
        Employee e4 = new Employee("wiuyun", 51, new MyDate(1969, 3, 31));
        Employee e5 = new Employee("wanghaobo", 40, new MyDate(1980, 7, 19));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        System.out.println(set);
        Iterator<Employee> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
