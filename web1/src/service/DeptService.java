package service;

import entity.Dept;

import java.util.List;

/**
 * @author:吴云鹏@Date:2020/10/18 - Time:11:26
 * @ DESCRIPTION
 */
public interface DeptService {
    List<Dept> getAllDept();
    int insert(Dept dept);
}
