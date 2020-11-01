package utils;

import java.sql.*;

/**
 * JDbc自定义工具类
 *
 * @ author:吴云鹏
 * Date:2020/5/25
 * Time:23:30
 */
public class DButils1 {
    private static Connection conn = null;
    private static String url = "jdbc:mysql:///mydb1 ? " +
            "&useSSL=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "123456";
    //用于事务处理中获得单一不变的连接
    private static ThreadLocal<Connection> threadLocal= new ThreadLocal<Connection>();

    //获得连接
    public static Connection getConnection() {

        try {
            conn=threadLocal.get();
            if (conn==null) {
                conn = DriverManager.getConnection(url, user, password);
                threadLocal.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //开启事务
    public static void startTransAction(){
        conn=getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public static void commit(){
        conn=getConnection();
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //回滚事务
    public static void rollback(){
        conn=getConnection();
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(){
        conn=getConnection();
        if (conn!=null){
            try {
                conn.close();
                threadLocal.remove();//把ThreadLoaca里的线程对象移除掉
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

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
