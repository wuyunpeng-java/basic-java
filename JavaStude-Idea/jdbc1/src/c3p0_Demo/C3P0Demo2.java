package c3p0_Demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *@ author:吴云鹏
 * Date:2020/5/31
 * Time:17:51
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource("mysql");
        //2 获取连接对象
        for (int i=1;i<=9;i++){
            Connection conn = ds.getConnection();
            if (i==5){
                conn.close();
            }
            System.out.println(i+"::"+conn);
        }
    }
}
