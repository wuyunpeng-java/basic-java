package mysql_jdbc;

import utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**练习
 * 通过键盘输入用户名和密码，判断用户是否登录成功
 * 登录方法使用PreparedStatement实现，解决了SQL注入问题，排除了安全隐患
 * author:吴云鹏
 * Date:2020/5/25
 * Time:19:25
 */
public class JDBCForLogin2 {
    /**
     * 登录方法
     */
    public static boolean login(String username,String password){
        if (username==null || password==null){
            return false;
        }
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        //连接数据库判断是否登录成功
         conn = DButils.getConnection();
        String sql = "select * from user where username = ? and password= ? ";
        try {
//            获取执行SQL的对象
             psmt = conn.prepareStatement(sql);
//             给？赋值
            psmt.setString(1,username);
            psmt.setString(2,password);
             rs = psmt.executeQuery();
             return  rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeAll(rs,psmt,conn);
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
