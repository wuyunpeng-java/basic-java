package mysql_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc入门
 *修改一条表中的记录
 * @ author:吴云鹏
 * Date:2020/5/23
 * Time:0:48
 */
public class TestUpdate {
    public static void main(String[] args)  {
        // Class.forName("com.mysql.cj.jdbc.Driver");  -->此句可省略
        Connection conn=null;
        Statement stmt=null;

        try {
//            获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///mydb1 ? " +
                        "&useSSL=false&serverTimezone=GMT%2B8",
                "root", "123456");
            String sql = "update stu set Englishscore = 76.4 where id =7";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count>0) System.out.println("修改成功");
            else System.out.println("修改失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
