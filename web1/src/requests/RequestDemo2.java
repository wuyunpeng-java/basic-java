package requests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author:吴云鹏@Date:2020/11/9 - Time:15:33
 * @ DESCRIPTION 演示获取请求头数据
 */
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          1 获取所有的请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
//        遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
//            根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name +"---"+value);

        }
    }
}

