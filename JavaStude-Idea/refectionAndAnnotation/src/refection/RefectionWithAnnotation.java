package refection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**框架类
 * 不能改变该类的任何代码。可以创建任意类的对象并可以执行任意方法
 * Date:2020/5/3
 * Time:11:54
 * @author 吴云鹏
 */
@SuppressWarnings("uncheckted")
@Pro(className = "refection.Demo2",methodName = "show")
public class RefectionWithAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<RefectionWithAnnotation> ref = RefectionWithAnnotation.class;
        Pro an = ref.getAnnotation(Pro.class);
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);
        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
