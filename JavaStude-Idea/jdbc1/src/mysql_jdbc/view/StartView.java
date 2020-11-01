package mysql_jdbc.view;

import mysql_jdbc.dao.impl.AccountDAOImpl;
import mysql_jdbc.service.impl.AccountServiceImpl;

import java.util.Scanner;

/**
 *@ author:吴云鹏
 * Date:2020/6/2
 * Time:19:18
 */
public class StartView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎登陆转账系统：  ");
        System.out.println("请输入卡号： ");
        int from = sc.nextInt();
        System.out.println("请输入对方卡号：");
        int to = sc.nextInt();
        System.out.println("请输入转账金额：");
        double money = sc.nextDouble();
        //调用业务层
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.transfer(from,to,money);

    }
}
