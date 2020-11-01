package mysql_jdbc.service;

/**
 *@ author:吴云鹏
 * Date:2020/6/2
 * Time:18:58
 */
public interface AccountService {
    //提供给UI（用户界面层）-->转账
   void transfer(int fromCard,int toCard,double money);
}
