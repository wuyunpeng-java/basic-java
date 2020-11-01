package streamstudy.filter;

import java.util.stream.Stream;

/**Stream流中的常用方法filter用于对流中的数据进行过滤
 *@ author:吴云鹏
 * Date:2020/4/30
 * Time:21:13
 */
public class StreamFiltetTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌", "张翠山", "张三丰", "赵敏", "周芷若");
        Stream<String> stream2 = stream.filter(e ->
            e.startsWith("张"));
        stream2.forEach(System.out::println);
    }
}
