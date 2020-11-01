package mysql_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ author:吴云鹏
 * Date:2020/5/23
 * Time:19:29
 */
public class TestDDL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///mydb1 ? " +
                        "&useSSL=false&serverTimezone=GMT%2B8",
                "root", "123456");
        String sql = "create table test (id int , name varchar(20) )";
        //创建执行SQL语句的对象
        Statement stmt = conn.createStatement();
        //执行DDL，用execute方法
        boolean b = stmt.execute(sql);
        stmt.executeUpdate("insert test(id,name) values (1,'吴云鹏5')");
        System.out.println(b);
        stmt.close();
        conn.close();
    }
}
