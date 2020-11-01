package bufferedstream;

import org.junit.Test;

import java.io.*;

/**处理流之一：缓冲流的使用
 * 缓冲流：BufferInputStream;BufferedOutputStream;
 * BufferedReader;BufferedWriter
 * 作用：提高流的读取及写入的速度；
 *@ author:吴云鹏
 * Date:2020/4/18
 * Time:20:35
 */
public class BufferedTest {

    @Test
    public void bufferedStreamTest()  {
        BufferedInputStream bufis =null;
        BufferedOutputStream bufos =null;

        try {
            FileInputStream fis = new FileInputStream("D:\\BaiduNetdiskDownload\\JavaSE基础视频21\\IO流\\22-IO流(字节流-练习-复制MP3).mp4");
            FileOutputStream fos = new FileOutputStream("复制MP3.mp4");
            bufis = new BufferedInputStream(fis);
            bufos = new BufferedOutputStream(fos);
            byte[] buf =new byte[10240];
            int len =0;
            while ((len = bufis.read(buf)) != -1){
                bufos.write(buf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufis != null)
                bufis.close();
                if (bufos != null)
                bufos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
