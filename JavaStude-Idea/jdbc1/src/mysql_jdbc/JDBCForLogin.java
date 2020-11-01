package mysql_jdbc;

import utils.DButils;

import java.sql.*;
import java.util.Scanner;

/**练习
 * 通过键盘输入用户名和密码，判断用户是否登录成功
 * 此程序有BUG.-->SQL注入问题，存在安全隐患
 * author:吴云鹏
 * Date:2020/5/25
 * Time:19:25
 */
public class JDBCForLogin {
    /**
     * 登录方法
     */
    public static boolean login(String username,String password){
        if (username==null || password==null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //连接数据库判断是否登录成功
         conn = DButils.getConnection();
        String sql = "select * from user where username ='"+username+"' and password='"+password+"' ";
        try {
             stmt = conn.createStatement();
             rs = stmt.executeQuery(sql);
            return  rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeAll(rs,stmt,conn);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();

        boolean flag = login(username, password);
        if (flag)
            System.out.println("登录成功！");
        else
            System.out.println("用户名或密码错误！");
    }
}
