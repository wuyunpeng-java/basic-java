package functionalInterface.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

/**集合信息筛选
 * 数组中有多条“姓名+性别”的信息如下：
 * String Array[] ={"迪丽热巴,女","古力娜扎，女","马尔扎哈,男","赵丽颖,女"}
 *需要同时满足两个条件：性别为女且姓名为4个字。并将满足条件的项用集合保存
 * @ author:吴云鹏
 * Date:2020/4/30
 * Time:17:59
 */
public class PredicateExer {
    public static ArrayList<String> filter(String[] arr, Predicate<String>pre1,Predicate<String>pre2){
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean b = pre1.and(pre2).test(s);
            if (b){
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] array ={"迪丽热巴,女","古力娜扎,女","马尔扎哈,男","赵丽颖,女","吴云鹏,男"};
       ArrayList<String> list=filter(array,(String s)->{
           return "女".equals(s.split(",")[1]);
        },(String s)->{return s.split(",")[0].length()==4;});
        System.out.println(list);
    }
}
