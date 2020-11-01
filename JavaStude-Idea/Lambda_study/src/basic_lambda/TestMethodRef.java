package basic_lambda;

import exer1.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ author:吴云鹏@Date:2020/10/16 - Time:14:40
 * @ DESCRIPTION:若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * 可以理解为方法引用是Lambda表达式的另外一种表现形式
 * 主要有三种语法格式：
 * 1 对象::实例方法名； 2 类::静态方法名； 3 类::实例方法名
 * 注意：1 Lambda体中调用方法的参数列表和返回值类型，要与函数式接口中抽象方法的参数列表和返回值类型保持一致
 * 2 若Lambda参数列表中的第一参数是实例方法的调用者，而第二参数是实例方法的参数时，可以使用类名::实例方法的形式
 * 谈谈构造器引用
 * 格式：
 */
public class TestMethodRef {
//    对象::实例方法名
    @Test
    public void test1(){
        Consumer<String> con =System.out::println;
        con.accept("吴云鹏");
    }
    @Test
    public void test2(){
        Employee emp =new Employee("吴云鹏",50,null);
        Supplier<String> sup =()->emp.getName();
        String str = sup.get();
        System.out.println(str);
        Supplier<Integer> sup1 =()->emp.getAge();
        System.out.println(sup1.get());

    }
//    类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> comp =Integer::compare;
    }
//    类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> bp =String::equals;
        boolean b = bp.test("吴云鹏", "吴荣鹏");
        System.out.println(b);

    }
    /*构造器引用
    * 注意：需要调用的构造器的参数列表需要与函数式接口中的抽象方法的参数列表保持一致*/


    @Test
    public void test5(){
        Supplier<Employee> sup =Employee::new;
        Employee emp = sup.get();
        System.out.println(emp);
    }
//    数组引用
    @Test
    public void test6(){
        Function<Integer,String[]> fun =String[]::new ;
        String[] str = fun.apply(20);
        System.out.println(str.length);
    }
}
