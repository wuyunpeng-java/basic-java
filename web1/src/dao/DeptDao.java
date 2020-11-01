package dao;

import entity.Dept;

import java.util.List;

/**
 * @ author:吴云鹏@Date:2020/10/18 - Time:10:53
 * @ DESCRIPTION
 */
public interface DeptDao {
    List<Dept> getAllDept();
    int insert(Dept dept);
}
