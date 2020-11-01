package TCP.sendfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写“上传成功”
 *@ author:吴云鹏
 * Date:2020/4/26
 * Time:23:35
 */
public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        //创建服务器套接字
        ServerSocket server = new ServerSocket(8088);
        System.out.println("服务器启动成功，等待用户接入...");
        //等待用户接入
        Socket client = server.accept();
        //获取客户端地址（可无）
        System.out.println("有客户端接入，客户端IP:"+ client.getInetAddress());
        InputStream is = client.getInputStream();
        FileOutputStream fos = new FileOutputStream("d:\\1.jpg");
        int len =0;
        byte[] bytes = new byte[1024];
        while ((len =is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        client.getOutputStream().write("上传成功".getBytes());
        fos.close();
        client.close();
        server.close();
    }
}
