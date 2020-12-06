package logins;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ author:吴云鹏@Date:2020/10/13 - Time:23:15
 * @ DESCRIPTION
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获得浏览器发送的请求数据
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("曹满意") && password.equals("123456")){
            session.setAttribute("username",username);
            Cookie cookie = new Cookie("userinfo", username + "#" + password);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24*7);
            response.getWriter().println("登录成功");

        }else {  response.sendRedirect("/web1/Fail.html");
        }
    }
}
