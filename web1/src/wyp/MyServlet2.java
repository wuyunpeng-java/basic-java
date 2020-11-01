package wyp;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 *@ author:吴云鹏 @Date:2020/10/7 - Time:18:58
 * @ DESCRIPTION
 */
public class MyServlet2 extends GenericServlet {
/*1 省略了4个方法，继承进行使用即可。
与协议无关！
基于一般的WEB项目有http协议，该方法无法满足项目需求
* */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("提供服务....");

    }
}
