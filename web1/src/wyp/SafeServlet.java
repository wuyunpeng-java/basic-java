package wyp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/10/24 - Time:16:41
 * @ DESCRIPTION
 */
@WebServlet(name = "SafeServlet", value = "/ss")
public class SafeServlet extends HttpServlet {
//    线程不安全，每个线程访问的数据都可能是不准确的
    int num =1;//多个线程访问一个Servlet(对象),共享成员变量
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    num++;
        System.out.println("当前num的值为："+num);


    }
}
