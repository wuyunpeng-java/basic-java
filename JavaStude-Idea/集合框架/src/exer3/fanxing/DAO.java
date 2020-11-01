package exer3.fanxing;

import java.util.*;

/**
 * 定义泛型类DAO</T>,在其中定义一个MAP成员变量。键为String类型，值为T类型。
 * 创建以下方法：
 * void save(String id,T entity)将T类型的对象保存到MAP成员变量中
 * T get（String id）：从map中获取id对应的对象；
 * void update (String id,T entity)替换map中key为id的内容，改为entity对象
 * List<T>list()返回map中存放的所有T对象
 * void delete(String id)删除指定的id对象
 *
 * @ author:吴云鹏
 * Date:2020/4/15
 * Time:22:55
 */
public class DAO<T> {
    private Map<String, T> map =new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id){

        return map.get(id);
    }
  public   void update (String id,T entity){
        if(map.containsKey(id)){
            map.put(id,entity);
        }
  }
  public  List<T> list(){
      List<T> ts = new ArrayList<>();
      Collection<T> values = map.values();
      for(T t : values) {
          ts.add(t);
      }
      return ts;

  }
  public void delete(String id){
        map.remove(id);
  }


}
