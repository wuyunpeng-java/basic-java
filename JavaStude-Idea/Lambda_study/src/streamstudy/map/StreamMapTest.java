package streamstudy.map;

import java.util.stream.Stream;

/**将流中的元素映射(转换另一种数据类型...)到另一个流中，可以使用map方法；
 * <R>Stream<R> map(Function(<? super T,? extends R> mapper));
 * Function中的抽象方法：R apply（T t）
 * author:吴云鹏
 * Date:2020/4/30
 * Time:21:45
 */
public class StreamMapTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "15", "3", "23");
         stream.map(Integer::parseInt).forEach(System.out::println);
    }
}
