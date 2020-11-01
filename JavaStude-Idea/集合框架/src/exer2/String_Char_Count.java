package exer2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 计算一个字符串中每个字符出现的次数
 * 1，使用Scanner获取用户键盘输入的字符串；2创建Map集合，KEY是字符串中的字符，Value是每个字符出现的次数
 * 3，遍历字符串获取每一个字符；4，使用获取到的字符去MAP集合中判断相应的KEY是否存在；
 * <p>
 * Date:2020/4/14
 * Time:19:55
 *
 * @author Administrator
 */
public class String_Char_Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            if (map.containsKey(c)) {
                Integer value = map.get(c);
                value++;

                map.put(c, value);
            } else {
                map.put(c, 1);
            }
        }
        for(Character key:map.keySet()){
            Integer value =map.get(key);
            System.out.println(key+"="+value);
        }

    }

}
