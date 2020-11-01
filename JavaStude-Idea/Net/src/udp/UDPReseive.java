package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**接收端
 * 1 使用DatagramSocket 指定端口 创建接收端
 * 2 准备容器封装成DatagramPacket包裹
 * 3 阻塞式接收reseive(DatagramPacket p)
 * 4 分析数据 byte[] getData() 以及getLength()
 * 5 释放资源
 *@ author:吴云鹏
 * Date:2020/5/17
 */
public class UDPReseive {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中......");
        byte[] container = new byte[1024 * 10];
        DatagramSocket server = new DatagramSocket(9999);
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);
        int len =packet.getLength();
        System.out.println(new String(container, 0, len));
        server.close();

    }

}
