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
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          1 获取所有的请求头数据-->user-agent
        request.setCharacterEncoding("UTF-8");
        String agent = request.getHeader("user-agent");
//        判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            System.out.println("谷歌来了....");
        }else if (agent.contains("Firefox")){
            System.out.println("火狐来了....");
        }


    }
}

