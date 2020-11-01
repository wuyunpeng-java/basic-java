package dao;

import domain.User;

import java.util.List;

/**
 * @author:吴云鹏@Date:2020/11/16 - Time:22:51
 * @ DESCRIPTION 用户的持久层接口
 */
public interface IUserDao {
    /*
    * 查询所有操作*/
    List<User> findAll();

}
