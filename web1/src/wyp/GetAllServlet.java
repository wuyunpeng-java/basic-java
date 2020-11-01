package wyp;

import entity.Dept;
import service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author:吴云鹏@Date:2020/10/18 - Time:11:38
 * @ DESCRIPTION
 */
@WebServlet(name = "GetAllServlet", value = "/getall")
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//调用Service
        response.setContentType("text/html;charset=utf-8");
        DeptServiceImpl deptService = new DeptServiceImpl();
        List<Dept> allDept = deptService.getAllDept();
        PrintWriter writer = response.getWriter();
//        手敲页面
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset ='utf-8'>");
        writer.println("<title>查询所有</title>");
        writer.println("<head>");
        writer.println("<body>");
        for(Dept dept :allDept){
            writer.println(dept.getDeptno()+"---"+dept.getDname()+"---"+dept.getLoc());
            writer.println("<br>");
        }
        writer.println("</body>");
        writer.println("<html>");

    }
}
