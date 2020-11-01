package iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用Iterator接口
 *
 * @ author:吴云鹏
 * Date:2020/4/11
 * Time:12:45
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry", 22));
        coll.add("Tom");
        coll.add(false);
        Iterator iterator = coll.iterator();
        //方式一：（开发中不推荐）
        /*for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }*/
        //方式二（推荐）
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    /*×
    演示Iterator的remove()的使用
    */
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry", 22));
        coll.add("Tom");
        coll.add(false);
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (Integer.valueOf(123).equals(obj)){
                iterator.remove();
            }
        }
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
