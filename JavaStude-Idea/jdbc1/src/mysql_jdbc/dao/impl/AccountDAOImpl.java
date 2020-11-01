package mysql_jdbc.dao.impl;

import mysql_jdbc.dao.AccountDAO;
import utils.DButils1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *@ author:吴云鹏
 * Date:2020/6/2
 * Time:17:39
 */
public class AccountDAOImpl implements AccountDAO {
    Connection conn =null;
    PreparedStatement stmt =null;
    @Override
    public int saveMoney(int cardNo, double money) {
        conn= DButils1.getConnection();
        String sql ="update account set money=money+? where id=?";
        try {
            stmt=conn.prepareStatement(sql);
            stmt.setDouble(1,money);
            stmt.setInt(2,cardNo);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils1.closeAll(null,stmt,null);
        }
        return 0;
    }

    @Override
    public int takeMoney(int cardNo, double money) {
        conn= DButils1.getConnection();
        String sql ="update account set money=money-? where id=?";
        try {
            stmt=conn.prepareStatement(sql);
            stmt.setDouble(1,money);
            stmt.setInt(2,cardNo);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils1.closeAll(null,stmt,null);
        }
        return 0;
    }
}
