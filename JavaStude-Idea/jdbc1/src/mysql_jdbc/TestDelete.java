package mysql_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ author:吴云鹏
 * @ Date:2020/5/23
 * Time:20:28
 * 删除表中的一条记录
 */
public class TestDelete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注意：在mysql中，此句可省略
        // Class.forName("com.mysql.cj.jdbc.Driver");
        //默认本机及端口3306的URL可以省略
        Connection conn = DriverManager.getConnection("jdbc:mysql:///mydb1 ? " +
                        "&useSSL=false&serverTimezone=GMT%2B8",
                "root", "123456");
        Statement stmt = conn.createStatement();
        // stmt.execute("truncate table test");
        int i = stmt.executeUpdate("delete from stu where id=7");
        if (i > 0) System.out.println("执行成功");
        else System.out.println("执行失败");
        conn.close();
        stmt.close();
    }


}
