package requests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/11/11 - Time:23:38
 * @ DESCRIPTION :获取请求消息体-->请求参数(适用于post请求方式）
 * 后面有关于获取请求参数的通用方式
 */
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1 获取字符流
        BufferedReader br = request.getReader();
//        2 读取数据
        String line = null;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
