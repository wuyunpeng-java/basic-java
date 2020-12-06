package cookies;

import com.alibaba.druid.sql.visitor.functions.If;
import sun.text.resources.cs.FormatData_cs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/12/3 - Time:23:23
 * @ DESCRIPTION
 */
@WebServlet("/cs2")
public class CookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取Cookie
        Cookie[] cs = request.getCookies();
//        获取数据，遍历Cookie数组
        if (cs !=null){
            for (Cookie c : cs) {
                String name=c.getName();
                String value=c.getValue();
                System.out.println(name+": "+value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
