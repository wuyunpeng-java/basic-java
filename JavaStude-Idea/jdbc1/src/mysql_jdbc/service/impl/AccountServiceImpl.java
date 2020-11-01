package mysql_jdbc.service.impl;

import mysql_jdbc.dao.AccountDAO;
import mysql_jdbc.dao.impl.AccountDAOImpl;
import mysql_jdbc.service.AccountService;
import utils.DButils1;

/**
 * @ author:吴云鹏
 * Date:2020/6/2
 * Time:19:06
 */
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public void transfer(int fromCard, int toCard, double money) {
        try {
            //开启事务
            DButils1.startTransAction();
            System.out.println("开启事务提交");
            //1 调用DAO扣钱
            int take = accountDAO.takeMoney(fromCard, money);
           // int i = 10 / 0;
            //2 调用DAO加钱
            int save = accountDAO.saveMoney(toCard, money);
            System.out.println("提交事务成功");
            DButils1.commit();
            //3 打印结果
            if (take == 1 && save == 1) {
                System.out.println("转账成功");
            } else {
                System.out.println("转账失败");

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现了异常，事务回滚");
            DButils1.rollback();

        }finally {
            DButils1.close();
        }
    }
}
