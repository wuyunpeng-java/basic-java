package basic_lambda;

import exer1.Employee;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Consumer;

import functionalInterface.StreamAPITest1;

/**
 *@ author:吴云鹏 @Date:2020/10/8 - Time:10:24
 * @ DESCRIPTION
 * 语法格式一：所对应的函数式编程接口中的抽象方法无参数无返回值： ()->功能实现块
 * 语法格式二：所对应的函数式编程接口中的抽象方法有一个参数无返回值：
 * 语法格式三：所对应的函数式编程接口中的抽象方法有两个以上参数且有返回值：
 */
public class BasicLambda {
    @Test
    public void test1(){
//        JAVA8之前的实现方式
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world !");
            }
        };
        r.run();
        System.out.println("---------------------------------------------------------------------------------");
//        用lambda表达式实现
      Runnable r1=()-> System.out.println("hello lambda !");
      r1.run();
    }
    @Test
    public void test2(){
//        如果只有一个参数，参数旁边的小括号可以不写（写上也可以）
        Consumer con =x-> System.out.println(x);
        con.accept("我大尚硅谷威武！");
        con.accept(168.356);
        con.accept(new Employee("吴云鹏",51,null));
    }
    @Test
    public void test3(){
//        所对应的函数式编程接口中的抽象方法有两个以上参数且有返回值：并且如有多条语句，如下示例
//        如还是只有一条语句，return及大括号及后面的分号都是可以省略的
        Comparator<Integer> com = (x,y)->{
            System.out.println("函数式编程：");
            return  Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
//        所对应的函数式编程接口中的抽象方法有两个以上参数且有返回值：并且如只有一条语句，如下示例
//        return及大括号及后面的分号都是可以省略的
        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);

    }
    @Test
//    定制排序比较list集合中Employee的元素（先按年龄，再按姓名排序）
    public void test5(){
        StreamAPITest1 s1 = new StreamAPITest1();
        System.out.println(s1.list);
        System.out.println("----------------------------------------------------------------------");
        Collections.sort(s1.list,(e1,e2)->{
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (bean.Employee emp : s1.list){
            System.out.println(emp);
        }
    }
    @Test
    public void test6(){
        String s = strHandler("dedfd", (str) -> str.toUpperCase());
        System.out.println(s);
        String s1 = strHandler("我大尚硅谷威武！", (str) -> str.substring(2, 5));
        System.out.println(s1);
    }
    //下面该方法的设立也是为了给上面的test6调用-->用于处理字符串
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }
    //需求：对于两个long型数据进行处理如下方法（需先定义接口）
    public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }
    @Test
    public void test7(){
        op(13l,200l,(x,y)->x+y);
        op(13l,200l,(x,y)->x*y);
    }
}

//下面的函数式接口作为上面test6的调用
@FunctionalInterface
interface MyFunction{
    public String getValue(String str);
}


