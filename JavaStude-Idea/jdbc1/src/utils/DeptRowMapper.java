package utils;

import bean.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *@ author:吴云鹏
 * Date:2020/6/6
 * Time:16:29
 */
public class DeptRowMapper implements RowMapper<Dept>{
    @Override
    public Dept getRow(ResultSet rs) {
        Dept dept = new Dept();
        //在结果集里拿数据进行对象的赋值
        try {
            dept.setId(rs.getInt(1));
            dept.setDname(rs.getString("dname"));
            dept.setLoc(rs.getString("loc"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
}
