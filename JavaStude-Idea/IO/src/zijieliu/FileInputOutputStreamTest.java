package zijieliu;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**测试FileInputStream和FileOutputStream的使用
 * author:吴云鹏
 * Date:2020/4/18
 * Time:13:41
 * 注意：文件中如果有中文会出现乱码
 */
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputOutputStream() throws IOException {
        FileInputStream fis = new FileInputStream("haha.txt");
        byte[] buff = new byte[6];
        int len;
        while ((len=fis.read(buff)) != -1){
            for(int i=0;i<len;i++){
                System.out.print((char)buff[i]);
            }
        }
        fis.close();
    }
    @Test
    public void  testFileInputOutputStream1(){
        FileInputStream fis =null;
        FileOutputStream fos =null;
        try {
             fis = new FileInputStream("D:\\Pictures\\报名照片.jpg");
             fos = new FileOutputStream("me.jpg");
            byte[] buff = new byte[1024];
            int len;
            while ((len =fis.read(buff)) != -1){
                fos.write(buff,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null)
                fis.close();
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
