package service.impl;

import dao.DeptDao;
import dao.impl.DeptDaoImpl;
import entity.Dept;
import service.DeptService;

import java.util.List;

/**
 * @author:吴云鹏@Date:2020/10/18 - Time:11:30
 * @ DESCRIPTION
 */
public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao=new DeptDaoImpl();
    @Override
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }

    @Override
    public int insert(Dept dept) {
        return deptDao.insert(dept);
    }
}
