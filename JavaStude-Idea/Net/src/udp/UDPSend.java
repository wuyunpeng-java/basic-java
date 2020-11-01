package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1 使用DatagramSocket 指定端口 创建发送端
 * 2 准备数据并转成字节数组并封装成DatagramPacket包裹（需要指定目的地）
 * 3 发送包裹send(DatagramPacket p)
 * 4 释放资源
 * author:吴云鹏
 * Date:2020/5/17
 * Time:15:48
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中......");
        DatagramSocket client = new DatagramSocket(8888);
        String data = "上海尚学堂";
        byte[] datas = data.getBytes();
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length
                , new InetSocketAddress("localhost", 9999));
        client.send(packet);
        client.close();
    }
}
