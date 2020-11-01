package wyp;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/11/16 - Time:21:09
 * @ DESCRIPTION
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取request域中共享的User对象
        User user = (User)request.getAttribute("user");

//  给页面写一句话
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("登录成功！"+user.getUsername()+",欢迎您！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
