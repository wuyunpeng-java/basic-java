package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/10/29 - Time:12:23
 * @ DESCRIPTION
 */
@WebServlet(name = "CookieServlet",value="/cs")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1,创建了一个Cookie对象 默认生命周期：浏览器关闭
        Cookie cs = new Cookie("username", "吴云鹏");
        Cookie cs1 = new Cookie("msg", "hello");
//        1.1 cookie的生命周期：负数-->浏览器内存；0-->失效；正数：生效时间：（秒）
        cs.setMaxAge(60*60);
        cs1.setMaxAge(30);
//        2，给浏览器
        response.addCookie(cs);
        response.addCookie(cs1);
    }
}
