package mysql_jdbc.dao;

/**
 *@ author:吴云鹏
 * Date:2020/6/2
 * Time:17:34
 */
public interface AccountDAO {
    //加钱
    int saveMoney(int cardNo,double money);
    //减钱
    int takeMoney(int cardNo,double money);
}
