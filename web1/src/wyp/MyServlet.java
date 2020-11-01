package wyp;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Date;
/**
实现接口的所有方法
*/
public class  MyServlet implements Servlet
{
	// 1 初始化方法
	 public void init(ServletConfig servletConfig) throws ServletException{
		 // servlet 初始化工作
		 System.out.println("初始化方法");
	 }
	 //2 获取servlet配置信息
	 public ServletConfig getServletConfig(){
		 return null;
	 }
	 //3 提供服务
	 public void  service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		 System.out.println("这是我的第一个Servlet");
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter print =response.getWriter();
		 print.println("这是IDEA的第一个Servlet");
		 Date date = new Date();
		 print.println(date);
		 print.close();
	 }
	 //4 返回servlet基本信息
	 public String getServletInfo(){
		 System.out.println("获取基本信息..........");
	 	return null;
	 }
	 //5 销毁
	 public void destroy(){
		 System.out.println("销毁方法.......");
	 }
}
