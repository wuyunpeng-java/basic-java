package 正则表达式;

import org.junit.Test;

/**
 * @author:吴云鹏
 * Date:2020/4/30
 * Time:13:24
 */
public class RegEXDemo {
    /**
     * 验证手机号码是否正确
     */
    @Test
    public void regexMatch() {
        String tel = "19000921111";
        String regex = "1[^29]\\d{9}";
        boolean b = tel.matches(regex);
        System.out.println(tel + ":" + b);

    }

}
