package basic_lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ author:吴云鹏@Date:2020/10/11 - Time:17:51
 * @ DESCRIPTION: JAVA8内置的四大函数式接口
 * 一 Consumer<T>:消费型接口。抽象方法：void accept<T t>
 * 二 Supplier<T>:供给型接口。抽象方法：T get()
 * 三 Function<T,R>:函数型接口。抽象方法：R apply(T t)
 * 四 Predicate<T>:断言型接口。抽象方法：boolean test(T t)
 */
public class BasicLambda1 {
    //    Consumer<T>:消费型接口
    @Test
    public void test1() {
        happy(1000, (m) -> System.out.println("去大保健消费了" + m + "元!"));
    }

    //    下面的happy方法供test1测试使用的
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //    Supplier<T>:供给型接口
    @Test
    public void test2() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(list);
    }

    //    产生指定个数的整数并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }
//    Function<T,R>:函数型接口
    @Test
    public void test3(){
        String s1 = strHandler("\t\t\t我大尚硅谷威武      ", (str) -> str.trim());
        System.out.println(s1);
        String s2 = strHandler(s1, (str) -> str.substring(2, 5));
        System.out.println(s2);
    }

    //    需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
//    Predicate<T>:断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("www", "atguigu", "Lambda", "html", "ok","吴云鹏帅");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        for (String s : strList) {
            System.out.println(s);
        }
    }

//    将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}
