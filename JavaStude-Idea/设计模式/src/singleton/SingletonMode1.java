package singleton;

/**饿汉式单例模式
 * author:吴云鹏
 * Date:2020/5/3
 * Time:22:48
 */
public class SingletonMode1 {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s);

    }
}
class Singleton{
 private  static final Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}