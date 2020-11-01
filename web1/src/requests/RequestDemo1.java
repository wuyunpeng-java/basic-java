package requests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ author:吴云鹏@Date:2020/11/7 - Time:22:30
 * @ DESCRIPTION 演示Request对象获得请求行数据
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");(设置后中文仍然是乱码，待解决）
//        1 获取请求方式：GET
        String method = request.getMethod();
        System.out.println(method);
//        2 获取虚拟目录（*）
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
//        3 获取Servelet路径（了解一下)
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
//        4 获取get方式的请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
//        5 获取请求的URI(*)
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
//        6 获取协议及版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
//        7 获取客户机的IP
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
