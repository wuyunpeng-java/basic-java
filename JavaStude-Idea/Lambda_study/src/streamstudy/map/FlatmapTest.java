package streamstudy.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * author:吴云鹏
 * Date:2020/5/12
 * Time:21:15
 */
public class FlatmapTest {
    public static void main(String[] args) {
        String[] words = {"Hello", "World"};
        Stream<String> a = Arrays.stream(words);

        a.map(word -> word.split(""))//
        .flatMap(Arrays::stream)
                .distinct()
                .collect(toList())
        .forEach(System.out::print);

    }

}
