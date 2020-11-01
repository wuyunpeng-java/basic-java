package dao.impl;

import dao.DeptDao;
import entity.Dept;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import javax.lang.model.element.VariableElement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ author:吴云鹏@Date:2020/10/18 - Time:10:58
 * @ DESCRIPTION
 */
public class DeptDaoImpl implements DeptDao {
    private QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
    @Override
    public List<Dept> getAllDept() {
        try {
         List<Dept> list=qr.query("select * from dept",new BeanListHandler<Dept>(Dept.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Dept dept) {
        try {
            int update = qr.update("insert dept (deptno,dname,loc) values(?,?,?)", dept.getDeptno(), dept.getDname(), dept.getLoc());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
