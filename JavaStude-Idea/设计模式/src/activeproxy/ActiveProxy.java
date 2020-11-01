package activeproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *此示例仅仅是创建了动态代理，但并未能体现动态代理的优势。
 * @ author:吴云鹏
 * Date:2020/5/6
 * Time:19:03
 */
interface Human {
    String getBelief();

    @SuppressWarnings("")
    void eat(String food);
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;
    public void bind(Object obj){
        this.obj=obj;
    }
    /**当我们通过代理类的对象调用方法A时，就会调用如下的方法：
     *将被代理类要执行的方法的功能就声明在invoke中
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用被代理方法前执行的代码....");
        //method:即为代理类对象调用的方法，此方法也就作为被代理类要调用的方法。obj为被代理类的对象
        Object returnValue= method.invoke(obj,args);
        //上述方法的返回值就作为当前invoke方法的返回值。
        System.out.println("调用被代理方法后执行的代码....");
        return returnValue;
    }
}

//被代理类
class SuperMan implements Human {
    @Override
    public String getBelief() {
        System.out.println("当前调用的是：getBelief");
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃 " + food);
    }
}

/**
 * 要想实现动态代理，需要解决的问题：
 * 1 如何根据加载到内存中的被代理类，动态地创建一个代理类及其对象；
 * 2 当通过代理类的对象调用方法时，如何动态地去调用被代理类的同名方法；
 */
class ProxyFactory {
    /**
     * 调用此方法，返回一个代理类对象
     */
    public static Object getProxyInstance(Object obj) {//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), handler);
    }
}

public class ActiveProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //ProxyInstance:代理类的对象
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("四川麻辣烫");
    }
}
