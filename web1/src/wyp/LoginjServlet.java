package wyp;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/11/16 - Time:20:43
 * @ DESCRIPTION
 */
@WebServlet("/loginServlet")
public class LoginjServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 1 设置编码
        request.setCharacterEncoding("UTF-8");
//        2 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        3 封装User对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
//        4 调用UserDAO的login()方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
//        5 判断user
        if (user==null){
            // 登录失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            //登录成功
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);

        }



    }
}
