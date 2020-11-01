package mysql_jdbc.dao.test;

import bean.Employee;
import mysql_jdbc.dao.EmpDao;
import mysql_jdbc.dao.impl.EmpDaoImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @ author:吴云鹏
 * Date:2020/5/31
 * Time:11:38
 */
public class TestEmp {
    EmpDao empDao = new EmpDaoImpl();

    @Test
    public void testGetAll() {
        List<Employee> emps = empDao.getAll();
        emps.forEach(System.out::println);
    }

    @Test
    public void testGetByNo() {
        Employee emp = empDao.getByNo(9);
        System.out.println(emp);
    }

    @Test
    public void testAdd() throws ParseException {
        Employee emp = new Employee();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int i = empDao.add(emp, null, "王栋民", "技术", "技术员", 3100, 500, sdf.parse("2005-12-15"));
        if (i > 0) {
            System.out.println("添加成功");
        } else System.out.println("添加失败");
    }

    @Test
    public void testUpdate() throws ParseException {
        //测试通过
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date2 = "2019-12-18";
        Date date = sdf.parse(date2);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        Employee emp = new Employee(16, "王炸", "工程部", "司机", 3000.0, 1200.0, 20, date1);
        int i = empDao.update(emp);
        if (i > 0) {
            System.out.println("修改成功");
        } else System.out.println("修改失败");
    }

    @Test
    public void testDelete() {
        //测试通过
        int i = empDao.delete(19);
        if (i > 0) {
            System.out.println("删除成功");
        } else System.out.println("删除失败");
    }

}
