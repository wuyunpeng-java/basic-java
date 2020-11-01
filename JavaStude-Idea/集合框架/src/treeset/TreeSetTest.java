package treeset;

import iterator.Person;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @ author:吴云鹏
 * Date:2020/4/12
 * Time:9:42
 * 向TreeSet中添加到数据，必须是相同类型的数据；
 * 两种排序方式：自然排序和定制排序
 */
public class TreeSetTest {
    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        set.add(new Person("wu",48));
        set.add(new Person("jerry",24));
        set.add(new Person("Jack",27));
        set.add(new Person("tom",27));
        set.add(new Person("Tom",27));
        set.add(new Person("wu",51));
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

    }
}
