package 日期时间类;

import org.junit.Test;

import java.util.Date;

/**
 * author:吴云鹏
 * Date:2020/4/5
 * Time:15:31
 * Data类：
 * 1：两个构造器的使用；2：两个方法的使用
 */
public class DataTimeTest2 {
    @Test

    public void test2() {
        //构造器1：Date()---创建一个对应当前时间的Date对象。==目前来看也是最有效的。另外一种指定毫秒数
        Date date1 = new Date();
        System.out.println(date1);

//     getTime()当前距离基准时间的毫秒数
        System.out.println(date1.getTime());
        new Date();

    }
}
