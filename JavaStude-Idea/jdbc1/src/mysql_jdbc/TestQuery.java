package mysql_jdbc;

import java.sql.*;

/**
 * @author:吴云鹏
 * @Date:2020/10/1 - Time:17:01
 */
public class TestQuery {
    public static void main(String[] args)  {
        // Class.forName("com.mysql.cj.jdbc.Driver");  -->此句可省略
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
//            获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///mydb1 ? " +
                            "&useSSL=false&serverTimezone=GMT%2B8",
                    "root", "123456");
            String sql = "select * from account";
            stmt = conn.createStatement();
//            执行SQL
            rs = stmt.executeQuery(sql);
//            处理结果
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);
                System.out.println(id + "---"+name+"---" + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
