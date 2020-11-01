package test;

import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author:吴云鹏@Date:2020/11/19 - Time:23:18
 * @ DESCRIPTION:测试BeanUtils的setProperty和getProperty方法
 */
public class BeanUtilTest {
    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"hehe","male");
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

}
