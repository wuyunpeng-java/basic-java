package mysql_jdbc.dao.impl;

import bean.Employee;
import mysql_jdbc.dao.EmpDao;
import utils.DButils1;
import utils.DButils2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ author:吴云鹏
 * @ Date:2020/5/31
 * Time:11:04
 */
public class EmpDaoImpl implements EmpDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;

    @Override
    public List<Employee> getAll() {
        conn = DButils2.getConnection();
        String sql = "select * from emp";
        Employee emp = null;
        ArrayList<Employee> emps = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String name = rs.getString("name");
                String dname = rs.getString("dname");
                String job = rs.getString("job");
                Date join_date = rs.getDate("join_date");
                double salary = rs.getDouble("salary");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");
                emp = new Employee(sid, name, dname, job, salary, comm, deptno, join_date);
                emps.add(emp);
            }
            return emps;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils1.closeAll(rs, psmt, conn);
        }
        return null;
    }

    @Override
    public Employee getByNo(int empNo) {
        conn = DButils1.getConnection();
        Employee emp = null;
        String sql = "select * from emp where sid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, empNo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                int sid = rs.getInt("sid");
                String name = rs.getString("name");
                String dname = rs.getString("dname");
                String job = rs.getString("job");
                Date join_date = rs.getDate("join_date");
                double salary = rs.getDouble("salary");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");
                emp = new Employee(sid, name, dname, job, salary, comm, deptno, join_date);
            }
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils1.closeAll(rs, psmt, conn);
        }
        return null;
    }

    @Override
    public int add(Employee emp, Object... args) {
        conn = DButils2.getConnection();
        String sql = "insert into emp(sid,`name`,dname,job,salary,comm,join_date)" +
                "values(?,?,?,?,?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {

                psmt.setObject(i + 1, args[i]);

            }
            // 3 执行
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils2.closeAll(rs, psmt, conn);
        }
        return 0;
    }

    @Override
    public int update(Employee emp) {
        conn = DButils2.getConnection();
        String sql = "update emp set `name` = ?,job=?,join_date=?,salary=?,comm=?,deptno=? where sid=?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setObject(1, emp.getName());
            psmt.setObject(2, emp.getJob());
            psmt.setObject(3, emp.getJoin_date());
            psmt.setObject(4, emp.getSalary());
            psmt.setObject(5, emp.getComm());
            psmt.setObject(6, emp.getDeptno());
            psmt.setObject(7, emp.getSid());
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils1.closeAll(rs, psmt, conn);
        }

        return 0;
    }

    @Override
    public int delete(int sid) {
        conn = DButils1.getConnection();
        String sql = "delete from emp where sid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, sid);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils2.closeAll(rs, psmt, conn);
        }
        return 0;
    }
}
