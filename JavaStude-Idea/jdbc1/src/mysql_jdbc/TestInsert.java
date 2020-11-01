package mysql_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 给acount表添加一条记录
 * author:吴云鹏
 * Date:2020/9/29
 * Time:18:29
 */
public class TestInsert {
    public static void main(String[] args) {

        //注意：在mysql中，此句可省略-->注册驱动
        // 1 Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = null;
        Statement stmt = null;
        //2定义SQL语句
        String sql = "insert into account values(8,'吴小华',2800)";
        try {
            //3 获取Connection对象。默认本机及端口3306的URL可以省略
            conn = DriverManager.getConnection("jdbc:mysql:///mydb1 ? " +
                            "&useSSL=false&serverTimezone=GMT%2B8",
                    "root", "123456");
            //4 获取执行SQL语句的对象
            stmt = conn.createStatement();
            //5 执行SQL
            int count = stmt.executeUpdate(sql);//影响的行数
            //6 处理结果
            System.out.println(count);
            if (count > 0) System.out.println("执行成功");
            else System.out.println("执行失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7 释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
