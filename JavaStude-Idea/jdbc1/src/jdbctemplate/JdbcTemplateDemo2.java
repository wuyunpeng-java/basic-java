package jdbctemplate;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;
import bean.Employee;

import java.util.List;
import java.util.Map;

/**
 *@ author:吴云鹏
 *@ Date:2020/6/1
 *@ Time:21:27
 */
public class JdbcTemplateDemo2 {
  private  JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    @Test
    public void testUpdate(){

        String sql="update emp set join_date ='2015-03-11' where sid=?";
         template.update(sql, 3);
    }
    @Test
    public void testInsert(){
        String sql ="insert emp(name,deptno,join_date)values(?,?,?)";
        int i = template.update(sql, "哈哈哈", 20, "2008-10-09");
        System.out.println(i);
    }
    @Test
    // emp表不能删除记录，因为有外键约束。因此用stu表来尝试
    public void testDelete(){
        String sql ="delete from stu where id=?";
        template.update(sql,14);
    }

    /**将查询的结果集封装为map集合；->将列名封装为KEY,将值封装为VALUE;
     * 下面测试查询的结果集记录数只能是1；
     */
    @Test
    public void testQuery1(){
        String sql ="select * from emp where sid =?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }
    /**
     * 查询多条记录，将其封装为List集合
     * 将每一条记录封装为MAP集合，然后降map封装到LIST中
     */
    @Test
    public void testQuery2(){
        String sql ="select * from emp where sid<?";
        List<Map<String, Object>> maps = template.queryForList(sql,10);
        maps.stream().forEach(System.out::println);
    }
    /**
     * 查询多条记录，并封装到表示为相应对象的List集合中
     */
    @Test
    public void testQuery3(){
        String sql ="select * from emp where sid>8";
        List<Employee> list = template.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
        list.stream().forEach(System.out::println);

    }

    /**
     * 查询总记录数（或者某个聚合函数值）
     */
    @Test
    public void testQuery4(){
        String sql ="select count(sid) from emp";
        Long total = template.queryForObject(sql, long.class);
        System.out.println(total);
    }
}

