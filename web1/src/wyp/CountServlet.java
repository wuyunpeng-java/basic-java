package wyp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/11/18 - Time:19:54
 * @ DESCRIPTION
 */
@WebServlet(name = "CountServlet", value="/count")

public class CountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        if (count==null){
            count=1;
            servletContext.setAttribute("count",count);
        }else {
            count++;
            servletContext.setAttribute("count",count);
        }
        response.getWriter().write("您是第"+count+"个访客");
    }
}
