package exer3.fanxing;

import java.util.List;

/**
 * author:吴云鹏
 * Date:2020/4/15
 * Time:23:45
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1015,24,"周华健"));
        dao.save("1003",new User(1008,34,"周心雨"));
        dao.update("1003",new User(1008,50,"吴玉佩"));
        dao.delete("1002");
        List<User> list = dao.list();
        for(User user : list) {
            System.out.println(user);
        }

    }
}
