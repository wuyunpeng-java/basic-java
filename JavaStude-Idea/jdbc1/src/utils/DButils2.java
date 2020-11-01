package utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * author:吴云鹏
 * Date:2020/5/26
 * Time:0:28
 */
public class DButils2 {
    /**
     * JDbc自定义工具类--跨平台
     *
     * @ author:吴云鹏
     * Date:2020/5/25
     * Time:23:30
     */
    private static Connection conn = null;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            InputStream is = DButils2.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(is);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获得连接
    public static Connection getConnection() {

        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源
    public static void closeAll(ResultSet resultSet, Statement stmt, Connection conn) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
