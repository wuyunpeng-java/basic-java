package mysql_jdbc;

import utils.DButils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * author:吴云鹏
 * Date:2020/5/25
 * Time:17:16
 */
public class JDBCForDQL {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        //1 注册驱动-->此处可省略
        // Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            //2 获取连接对象
            conn = DButils2.getConnection();
            //3 创建执行SQL语句对象
            stmt = conn.createStatement();
            //4 创建SQL语句
            String sql = "select * FROM department;";
            //5 执行sql语句
            resultSet = stmt.executeQuery(sql);
            //6 遍历
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dep_name = resultSet.getString(2);
                System.out.println("部门编号:" + id + "\t部门名称:" + dep_name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils2.closeAll(resultSet, stmt, conn);
        }
    }
}
