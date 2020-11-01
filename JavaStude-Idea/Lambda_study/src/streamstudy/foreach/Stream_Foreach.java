package streamstudy.foreach;

import java.util.stream.Stream;

/**本示例学习Stream中的常用方法-foreach。（终结方法，遍历之后就不能调用流中的其它方法了）
 * 并用自然排序（调用了String中的compareTo方法
 * void foreach(consumer(? super T)action)该方法接收一个consumer接口函数并将每一个流元素交给该函数处理
 *@ author:吴云鹏
 * Date:2020/4/30
 * Time:20:15
 */
public class Stream_Foreach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵柳", "钱琪","WYP");
        stream.sorted().forEach (System.out::println);
    }
}
