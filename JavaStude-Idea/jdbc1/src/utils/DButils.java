package utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**JDBC工具类
 * author:吴云鹏
 * Date:2020/6/6
 * Time:15:20
 */
public class DButils {
    /**
     * 配置文件只需要读取一次，可通过静态代码块实现
     */
    private static Connection conn = null;
    private static String url ;
    private static String user ;
    private static String password ;
    private static String driver ;

    static {
        try {
            //1 创建Properties集合类
            Properties prop = new Properties();
            //2 加载文件
         InputStream is = DButils.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(is);
            //3 获取数据，赋值
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver=prop.getProperty("driver");
            //4 注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() {

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }



    public static void close(Statement stmt,Connection conn) {
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
    //释放资源
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
