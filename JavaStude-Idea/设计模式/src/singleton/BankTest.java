package singleton;

/**使用同步机制将单例模式中的懒汉式改为线程安全的
 * 关键字：synchronized;
 * @author 吴云鹏
 */
public class BankTest {
}

class Bank{
    private  Bank(){}
    private static Bank instance =null;
    public static synchronized Bank getInstance(){
        if (instance == null){
            instance=new Bank();
        }
        return instance;
    }

}
