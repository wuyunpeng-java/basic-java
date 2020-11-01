package jdbctemplate;

import com.alibaba.druid.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

/**jdbcTemplate入门
 *@ author:吴云鹏
 * Date:2020/5/31
 * Time:19:14
 * @Date 验证成功
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
//        1,导入JAR包。创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql ="insert into account values(null,?,?)";
        String sql1 ="update account set money =5000 where id = ?";
        int i = template.update(sql, "程巧",8888.8);
        int i1 = template.update(sql1, 4);
        System.out.println(i+"，"+ i1);

    }
}
