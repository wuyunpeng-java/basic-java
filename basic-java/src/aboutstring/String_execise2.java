package aboutstring;

import org.junit.Test;

/**
 *@ author:吴云鹏
 * Date:2020/4/5
 * Time:19:43
 * 获取一个字符串在另一个长的字符串中出现的次数
 * 比如获取"ab"在"4hfabdfdfjfabdabdeab12ab"中出现的次数
 */
public class String_execise2 {

    public int getCount(String mainStr, String subStr) {
        int mainLenth = mainStr.length();
        int subLenth = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLenth > subLenth) {

            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index++;
            }

        }

        return count;
    }

    @Test
    public void test3() {
        String s1 = "35abdfjdk2dadabgabababab34adfjkabadsfababc";
        String s2 = "aba";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(getCount(s1, s2));
    }

    public String getMaxSub(String str1, String str2) {
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int lenth = minStr.length();
        for (int i = 0; i < lenth; i++) {
            for (int j = lenth - 1; j > i; j--) {
                if (maxStr.indexOf(minStr.substring(i, j)) != -1) {
                    return minStr.substring(i, j);
                }
            }
        }
        return null;
    }
    @Test
    public void test4() {
        String s1 = "35abdfjdk2dadabgabababab34adfjkabadsfababc";
        String s2 = "xxjdk2dafadazzzmyyababab2dad13";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(getMaxSub(s1, s2));
    }
}



