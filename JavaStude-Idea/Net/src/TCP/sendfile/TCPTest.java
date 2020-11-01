package TCP.sendfile;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**实现TCP的网络编程
 *@ author:吴云鹏
 * Date:2020/4/26
 * Time:14:45
 * 客户端发送文件到服务器，服务器保存到本地
 */
public class TCPTest {
    @Test
    public void clint() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fs = new FileInputStream("me.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fs.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[20];
        len=0;
        while ((len=is.read(buff))!=-1) {
            baos.write(buff, 0, len);
        }
        System.out.println(baos.toString());
        is.close();
        fs.close();
        os.close();
        socket.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("e://me2.jpg");
        int len;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        OutputStream os = socket.getOutputStream();
        os.write("你好，照片已收到！".getBytes());
        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }

}
