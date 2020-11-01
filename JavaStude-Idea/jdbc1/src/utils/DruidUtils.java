package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**Druid连接池的工具类
 * @ author:吴云鹏
 * @ Date:2020/5/31
 * @ Time:15:55
 */
public class DruidUtils {
    //创建连接池对象
    private static DruidDataSource dataSource;
    private static Connection conn;

    static {
//        加载配置文件
        Properties prop = new Properties();
        InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(is);
            //通过德鲁伊连接池工厂创建一个连接池，自动解析properties文件里的键值对。
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DruidDataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            conn=dataSource.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通用增删改-->验证插入新记录不成功！可以用JdbcTemplate的方法
     * @param sql
     * @param params
     * @return
     */
    public static int excuteUpdate(String sql,Object... params){
        conn=getConnection();
        PreparedStatement psmt=null;
        try {
            conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                psmt.setObject(i+1,params[i]);
            }
            int i = psmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(psmt,conn);
        }
        return  0;
    }
    //通用查询
    public static <T> List<T> query(String sql,RowMapper<T> rowMapper, Object... params){
        conn=getConnection();
        PreparedStatement psmt=null;
        ResultSet rs =null;
        List<T> list = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                psmt.setObject(i+1,params[i]);
            }
             rs = psmt.executeQuery();
            while (rs.next()){
                list.add(rowMapper.getRow(rs));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,psmt,conn);
        }
        return null;
    }
    public static void close(ResultSet resultSet, Statement stmt, Connection conn) {
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
    public static void close(Statement stmt, Connection conn) {
        try {

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
