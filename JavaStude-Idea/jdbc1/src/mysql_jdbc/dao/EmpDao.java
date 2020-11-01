package mysql_jdbc.dao;

import bean.Employee;

import java.util.List;

/**
 * 数据访问层接口，定义了访问数据库的方法
 *
 * @ author:吴云鹏
 * Date:2020/5/31
 * Time:10:51
 */
public interface EmpDao {
    List<Employee> getAll();

    Employee getByNo(int empNo);

    int add(Employee emp, Object... args);

    int update(Employee emp);

    int delete(int sid);
}
