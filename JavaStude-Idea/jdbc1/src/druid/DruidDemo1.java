package druid;

import utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author:吴云鹏@Date:2020/10/6 - Time:13:07
 * @ DESCRIPTION Druid基本演示
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
//        获取连接对象
        Connection conn = DruidUtils.getConnection();
//        定义SQL
        String sql ="insert into account values(null,?,?)";
//       获取psmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
//        给问号赋值
        stmt.setString(1,"汪浩波");
        stmt.setInt(2,9999);
//        执行SQL
        stmt.executeUpdate();
        System.out.println(conn);
//        关闭连接
        DruidUtils.close(stmt,conn);

    }
}
