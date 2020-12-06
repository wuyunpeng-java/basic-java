package wyp;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author:吴云鹏@Date:2020/11/29 - Time:23:17
 * @ DESCRIPTION
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 1,获取请求参数-->文件名称
        String filename = request.getParameter("filename");
//  2,使用字节输入流加载文件进内存
//        2.1 找到文件的服务器路径；
        String realPath = getServletContext().getRealPath("/img/" + filename);
//        2.2  用字节输入流关联
        FileInputStream fis = new FileInputStream(realPath);
//   3,设置response的响应头（类型及打开方式）-->这样可以不让浏览器直接打开显示而是新开一个下载窗口
        String mimeType = getServletContext().getMimeType(filename);
        response.setHeader("content-type",mimeType);
//        小插曲：中文文件名问题。两步：获取user-agent请求头（即浏览器的版本）；使用工具类编码文件名即可
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition","attachment;filename="+filename);
//   4,将输入流的数据写到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len =0;
        while ((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
