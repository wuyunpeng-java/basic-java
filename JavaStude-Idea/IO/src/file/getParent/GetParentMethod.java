package file.getParent;

import java.io.File;

/**演示getParent()方法的用法
 *@ author:吴云鹏
 * Date:2020/4/17
 * Time:20:29
 */
public class GetParentMethod {
    public static void main(String[] args) {
        File f =null;
        String v;
        boolean bool = false;
        f = new File("e://test.txt");
        v = f.getParent();
        bool = f.exists();
        if (bool){
            System.out.println("Parent name: " + v);
        }else {
            System.out.println(bool);
        }

    }

}
