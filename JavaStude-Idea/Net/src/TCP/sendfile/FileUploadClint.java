package TCP.sendfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**文件上传案例的客户端：读取本地文件，上传到服务器并读取服务器回写的数据
 * author:吴云鹏
 * Date:2020/4/26
 * Time:22:58
 */
public class FileUploadClint {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("e:\\1.jpg");
        //创建套接字，指定服务器地址及端口号
        Socket client = new Socket("127.0.0.1", 8088);
        OutputStream os = client.getOutputStream();
        os.write("TOMCAT你好".getBytes());
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        client.shutdownOutput();
        InputStream is = client.getInputStream();
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();
        client.close();
    }
}
