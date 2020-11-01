package exercise;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**图片加密
 * author:吴云鹏
 * Date:2020/4/18
 * Time:22:04
 */
public class PicTest {
    @SuppressWarnings("Duplicates")
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("me.jpg");
        FileOutputStream fos = new FileOutputStream("me_加密.jpg");
        byte[] buf =new byte[1024];
        int len;
        while ((len = fis.read(buf))!=-1){
            for (int i = 0; i <len ; i++) {
                buf[i]=(byte)(buf[i] ^ 5);
            }
            fos.write(buf,0,len);
        }
        fis.close();
        fos.close();
    }
    @SuppressWarnings("Duplicates")
    @Test
    public void jieMi() throws IOException {
        FileInputStream fis1 = new FileInputStream("me_加密.jpg");
        FileOutputStream fos1 = new FileOutputStream("me.jpg");
        byte[] buf1 =new byte[1024];
        int len1;
        while ((len1 = fis1.read(buf1))!=-1){
            for (int i = 0; i <len1 ; i++) {
                buf1[i]=(byte)(buf1[i] ^ 5);
            }
            fos1.write(buf1,0,len1);
        }
        fis1.close();
        fos1.close();
    }
}
