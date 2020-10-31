package aboutstring;

import org.junit.Test;

/**
 *@ author:吴云鹏
 * Date:2020/4/5
 * Time:17:56
 * 将一个字符串的给定部分反转
 * 方式一：转换为Char[];
 */
public class String_Execise {
    public String reverse(String str, int startIndex, int endIndex) {
        char[] arr = str.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;

        }
        return new String(arr);
    }
    /**方式二：用StringBuilder*/
    public String reverse1(String str,int startIndex,int endIndex){
        StringBuilder sb = new StringBuilder(str);
        String s =str.substring(startIndex,endIndex);
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder reversesb = sb1.reverse();
        String s1 = sb.replace(startIndex, endIndex,reversesb.toString()).toString();
        return s1;
    }
    @Test
    public  void test2(){
        String s = "7538bcdefgddjfhd34567";
        String s1 = reverse1(s, 2, 7);
        System.out.println(s);
        System.out.println(s1);
    }

    @Test
    public void test1() {
        String s = "abcdefg34567";
        String s1 = reverse(s, 2, 7);
        System.out.println(s);
        System.out.println(s1);
    }
}

