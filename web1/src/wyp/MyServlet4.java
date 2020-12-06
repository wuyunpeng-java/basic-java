package wyp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ author:吴云鹏@Date:2020/10/10 - Time:9:32
 * @ DESCRIPTION
 */
@WebServlet(name ="my4",value={"/m4","/mm4","/mmm4"})
public class MyServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Object msg = context.getAttribute("msg");
        System.out.println("注解式配置..."+msg);

    }
}
